module.exports = {
    testEnvironment: 'node',
    reporters: [
      'default',
      ['jest-junit', { 
        outputDirectory: '.',
        outputName: 'junit.xml',
        includeConsoleOutput: true 
      }]
    ],
    testMatch: ['**/__tests__/**/*.test.js'],
    globalSetup: './jest.setup.js',
    globalTeardown: './jest.teardown.js'
  };