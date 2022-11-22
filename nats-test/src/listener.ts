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

 enum Subjects {
	TicketCreated = 'ticket:created',
	TicketUpdated = 'ticket:updated',

	OrderCreated = 'order:created',
	OrderCancelled = 'order:cancelled',

	ExpirationComplete = 'expiration:complete',

	PaymentCreated = 'payment:created',
  }


interface Event {
	subject: Subjects;
	data: any;
  }

  export abstract class Listener<T extends Event> {
	abstract subject: T['subject'];
	abstract queueGroupName: string;
	abstract onMessage(data: T['data'], msg: Message): void;
	protected client: Stan;
	protected ackWait = 5 * 1000;

	constructor(client: Stan) {
	  this.client = client;
	}

	subscriptionOptions() {
	  return this.client
		.subscriptionOptions()
		.setDeliverAllAvailable()
		.setManualAckMode(true)
		.setAckWait(this.ackWait)
		.setDurableName(this.queueGroupName);
	}

	listen() {
	  const subscription = this.client.subscribe(
		this.subject,
		this.queueGroupName,
		this.subscriptionOptions()
	  );

	  subscription.on('message', (msg: Message) => {
		console.log(`Message received: ${this.subject} / ${this.queueGroupName}`);

		const parsedData = this.parseMessage(msg);
		this.onMessage(parsedData, msg);
	  });
	}

	parseMessage(msg: Message) {
	  const data = msg.getData();
	  return typeof data === 'string'
		? JSON.parse(data)
		: JSON.parse(data.toString('utf8'));
	}
  }
