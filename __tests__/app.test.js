const request = require('supertest');
const app = require('../index');

describe('GET /', () => {
  let server;
  
  beforeAll((done) => {
    server = app.listen(0, () => done()); // Use random port for tests
  });
  
  afterAll((done) => {
    server.close(done); // Properly close the server
  });

  it('responds with Hello message', async () => {
    const response = await request(server).get('/');
    expect(response.statusCode).toBe(200);
    expect(response.text).toBe('Hello from Node.js!');
  });
});