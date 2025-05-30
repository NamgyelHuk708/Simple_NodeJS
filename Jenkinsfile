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
        sh 'npm run test:ci'
      }
      post {
        always {
          junit 'junit.xml'
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