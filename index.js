const http = require('http');

const PORT = 3000;

const server = http.createServer((req, res) => {
  res.writeHead(200);
  res.end('Hello from Node.js CI/CD!');
});

server.listen(PORT, () => {
  console.log(`Server running on port ${PORT}`);
});
