import express from 'express';

const router = express.Router();

router.post('/api/users/signin', (req, res) => {
  res.send('<h1> Hi signin! </h1>');
});

export { router as signInRouter };
