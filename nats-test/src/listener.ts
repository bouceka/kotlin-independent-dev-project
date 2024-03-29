import { randomBytes, randomUUID } from 'crypto';
import nats, { Message, Stan } from 'node-nats-streaming';

console.clear();

const stan = nats.connect('nic-athletics', randomBytes(4).toString('hex'), {
  url: 'http://localhost:4222',
});

stan.on('connect', () => {
  console.log('Listener connected o NATS');

  stan.on('close', () => {
    console.log('NATS connection closed');
    process.exit();
  });

  const options = stan
    .subscriptionOptions()
    .setManualAckMode(true)
    .setDeliverAllAvailable()
    .setDurableName('team-service');
  const subscription = stan.subscribe('registration:created', 'team-service-queue-group', options);

  subscription.on('message', (msg: Message) => {
    const data = msg.getData();
    if (typeof data === 'string') {
      console.log(`Received event #${msg.getSequence()} with data: #${data}`);
    }
    msg.ack();
  });
});

process.on('SIGINT', () => stan.close());
process.on('SIGTERM', () => stan.close());


