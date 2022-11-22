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

  export abstract class Publisher<T extends Event> {
	abstract subject: T['subject'];
	protected client: Stan;

	constructor(client: Stan) {
	  this.client = client;
	}

	publish(data: T['data']): Promise<void> {
	  return new Promise((resolve, reject) => {
		this.client.publish(this.subject, JSON.stringify(data), (err) => {
		  if (err) {
			return reject(err);
		  }
		  console.log('Event published to subject', this.subject);
		  resolve();
		});
	  });
	}
  }
