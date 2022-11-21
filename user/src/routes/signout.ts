import express from 'express';

const router = express.Router();

router.post('/api/users/signout', (req, res) => {
  res.send('<h1> Hi signout! </h1>');
});

export { router as signOutRouter };
