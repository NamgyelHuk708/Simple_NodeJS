module.exports = {
    testEnvironment: 'node',
    reporters: [
      'default',
      ['jest-junit', { outputDirectory: '.', outputName: 'junit.xml' }]
    ],
    testMatch: [
      '**/__tests__/**/*.test.js',
      '**/?(*.)+(spec|test).js'
    ],
    testPathIgnorePatterns: [
      '/node_modules/'
    ]
  };