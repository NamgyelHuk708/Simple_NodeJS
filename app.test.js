const request = require('supertest');
const app = require('./app');

describe('Basic Tests', () => {
  test('App should be defined', () => {
    expect(app).toBeDefined();
  });

  test('GET / should return message', async () => {
    const response = await request(app).get('/');
    expect(response.statusCode).toBe(200);
    expect(response.text).toContain('Hello');
  });
});