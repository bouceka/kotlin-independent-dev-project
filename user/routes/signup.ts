import express from 'express';

const router = express.Router();

router.post('/api/users/singup', (req, res) => {
  res.send('<h1> Hi signup! </h1>');
});

export { router as signUpRouter };
