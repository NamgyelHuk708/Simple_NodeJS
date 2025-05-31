@Library('node-shared-lib') _

pipeline {
    agent any
    environment {
        APP_DIR = 'my-node-app'  
        DOCKER_IMAGE = 'namgyelhuk708/my-node-app:latest'
    }
    stages {
        stage('Install Dependencies') {
            steps {
                nodeUtils.installDependencies(env.APP_DIR)
            }
        }
        stage('Run Tests') {
            steps {
                nodeUtils.runTests(env.APP_DIR)
            }
        }
        stage('Build Docker Image') {
            steps {
                nodeUtils.buildDockerImage(env.APP_DIR, env.DOCKER_IMAGE)
            }
        }
        stage('Push to Docker Hub') {
            steps {
                nodeUtils.pushToDockerHub(env.DOCKER_IMAGE)
            }
        }
    }
}