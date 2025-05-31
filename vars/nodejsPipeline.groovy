def call(Map config = [:]) {
    // Set defaults if parameters aren't provided
    def defaults = [
        appName: 'nodejs-app',
        dockerHubUser: 'namgyelhuk708',
        dockerCredsId: 'dockerhub-creds',
        testCommand: 'npm test',
        buildCommand: 'npm run build'
    ]
    config = defaults + config

    pipeline {
        agent any

        environment {
            DOCKER_IMAGE = "${config.dockerHubUser}/${config.appName}"
            DOCKER_CREDS = credentials("${config.dockerCredsId}") 
        }

        stages {
            stage('Checkout') {
                steps {
                    checkout scm  // Gets the project code
                }
            }

            stage('Install') {
                steps {
                    sh """
                        echo "Installing dependencies..."
                        npm ci
                    """
                }
            }

            stage('Test') {
                steps {
                    sh """
                        echo "Running tests..."
                        ${config.testCommand}
                    """
                }
                post {
                    always {
                        junit 'junit.xml'  // Requires jest-junit
                        archiveArtifacts 'coverage/**/*'
                    }
                }
            }

            stage('Docker Build') {
                steps {
                    script {
                        docker.build("${env.DOCKER_IMAGE}:${env.BUILD_NUMBER}")
                    }
                }
            }

            stage('Docker Push') {
                steps {
                    script {
                        docker.withRegistry('', env.DOCKER_CREDS) {
                            docker.image("${env.DOCKER_IMAGE}:${env.BUILD_NUMBER}").push()
                            docker.image("${env.DOCKER_IMAGE}:latest").push()
                        }
                    }
                }
            }

            stage('Deploy') {
                when { 
                    branch 'main' 
                    expression { 
                        return env.BRANCH_NAME == 'main' 
                    }
                }
                steps {
                    echo "Deploying ${env.DOCKER_IMAGE}:${env.BUILD_NUMBER}"
                    // Add kubectl/SSH deployment here
                }
            }
        }

        post {
            failure {
                slackSend channel: '#ci-cd',
                         message: "Build Failed: ${env.JOB_NAME} #${env.BUILD_NUMBER}"
            }
            success {
                archiveArtifacts '**/build/**/*'
            }
        }
    }
}