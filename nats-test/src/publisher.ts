import { randomBytes, randomUUID } from 'crypto';
import nats, { Stan } from 'node-nats-streaming';

console.clear();

const stan = nats.connect('nic-athletics', 'publisherId', { url: 'http://localhost:4222' }); // stan -> instence of client

stan.on('connect', () => {
  console.log('Publisher connected to NATS');

  const data = JSON.stringify({
    id: '123',
    title: 'Men Volleyball',
    teamLimit: '9',
  });

  stan.publish('registration:created', data, () => {
    console.log('Event published');
  });
});
