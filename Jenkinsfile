@Library('node-shared-lib') _  // Make sure this matches your configured name

pipeline {
    agent any

    environment {
        IMAGE_NAME = 'namgyelhuk708/simple-node-app:latest' // Replace with your DockerHub username
        APP_DIR = '.'  // Or 'example-app' if your app is in a subfolder
        DOCKERHUB_CREDENTIALS_ID = 'docker-credentials'  // Set this in Jenkins
    }

    stages {
        stage('Install Dependencies') {
            steps {
                installDependencies(APP_DIR)
            }
        }

        stage('Run Tests') {
            steps {
                runTests(APP_DIR)
            }
        }

        stage('Build and Push Docker Image') {
            steps {
                buildAndPushDocker(APP_DIR, IMAGE_NAME, DOCKERHUB_CREDENTIALS_ID)
            }
        }
    }
}
