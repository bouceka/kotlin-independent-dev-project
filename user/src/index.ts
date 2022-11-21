import express from 'express';
import { json } from 'body-parser';
import 'express-async-errors'; // handles our async errors
import mongoose from 'mongoose';

import { currentUserRouter } from './routes/current-user';
import { signInRouter } from './routes/signin';
import { signOutRouter } from './routes/signout';
import { signUpRouter } from './routes/signup';
import { errorHandler } from './middlewares/error-handler';
import { NotFoundError } from './errors/not-found-error';

const app = express();
app.use(json());

app.use(currentUserRouter);
app.use(signInRouter);
app.use(signOutRouter);
app.use(signUpRouter);

app.all('*', async () => {
  throw new NotFoundError();
});
// middleware
app.use(errorHandler);

const start = async () => {
  try {
    await mongoose.connect('mongodb://user-mongo-srv:27017/user'); // connecting to a pod not LOCALHOST!!
    console.log('Connected to mongodb');
  } catch (err) {
    console.log(err);
  }
  app.listen(3000, () => {
    console.log('Listening on port 3000!!!!!');
  });
};

start();
