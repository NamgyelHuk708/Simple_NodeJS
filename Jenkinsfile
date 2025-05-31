// Jenkinsfile
@Library('nodejs-shared-lib@main') _

nodejsPipeline(
    appName: "nodejs-app",          // Lowercase, no spaces
    dockerHubUser: "namgyelhuk708",
    dockerCredsId: "dockerhub-creds",  // Must match Jenkins credentials ID
    testCommand: "npm run test:ci"    // Optional: override default test command
)