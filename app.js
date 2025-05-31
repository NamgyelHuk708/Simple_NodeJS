const express = require('express');
const app = express();

app.get('/', (req, res) => {
  res.send('Hello World!');
});

module.exports = app;

if (require.main === module) {
  const PORT = process.env.PORT || 3000;
  app.listen(PORT, () => console.log(`Server running on port ${PORT}`));
}