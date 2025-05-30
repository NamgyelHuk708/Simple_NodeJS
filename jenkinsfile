pipeline {
  agent any
  tools {
    nodejs 'NodeJS 24.0.2'
  }

  stages {
    stage('Install') {
      steps {
        sh 'npm install'
      }
    }

    stage('Test') {
      steps {
        sh 'npm test:ci'
      }
      post {
        always {
          junit 'junit.xml'
        }
      }
    }

    stage('Build') {
      steps {
        sh 'echo "No build step yet"'
      }
    }

    stage('Deploy') {
      steps {
        sh 'echo "Simulating deployment to staging..."'
      }
    }
  }
}
