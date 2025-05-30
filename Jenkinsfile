pipeline {
  agent any
  tools {
    nodejs 'NodeJS 24.0.2'
  }
  
  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }
    
    stage('Install Dependencies') {
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
        sh 'npm run build'
      }
    }
    
    stage('Deploy') {
      steps {
        sh 'echo "Deploying to staging..."'
        // Add your deployment commands here
      }
    }
  }
  
  post {
    always {
      archiveArtifacts artifacts: '**/build/**/*', fingerprint: true
    }
  }
}