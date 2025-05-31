@Library('node-shared-lib') _

nodePipeline(
    dockerImage: 'namgyelhuk708/my-node-app:latest',
    appDir: '.',
    testCommand: 'npm test',
    testReportPath: 'junit.xml',
    dockerCredentials: 'dockerhub-creds'
)