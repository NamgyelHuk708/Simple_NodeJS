@Library('node-shared-lib') _

nodePipeline(
    dockerImage: 'namgyelhuk708/my-node-app:latest',
    appDir: '.',
    testCommand: 'npm test', // Explicitly set test command
    dockerCredentials: 'dockerhub-creds' // Make sure this ID exists in Jenkins
)