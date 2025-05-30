pipeline {
  agent any
  tools {
    nodejs 'NodeJS 24.0.2'  // Must match the name in Global Tool Configuration
  }
  stages {
    stage('Install') {
      steps {
        sh 'npm install'
      }
    }
    stage('Test') {
      steps {
        sh 'npm run test:ci || echo "Tests failed - continuing to capture results"'
      }
      post {
        always {
          junit 'junit.xml'
          archiveArtifacts artifacts: 'junit.xml', allowEmptyArchive: true
        }
      }
    }
    stage('Build') {
      steps {
        sh 'npm run build'  // For React/Next.js apps
      }
    }
    stage('Deploy') {
      steps {
        sh 'echo "Deploying to staging..."'
        // Add deployment commands here
      }
    }
  }
}