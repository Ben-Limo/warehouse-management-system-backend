pipeline {
    agent any

    tools {
        maven "maven-3.8.6"
    }

    stages {
        stage('Check Environment') {
                steps {
                    echo "checking environment .."
                    sh "mvn -version"
             }
        }

        stage('Test') {
            steps {
                echo "Testing.."
                sh "mvn test"
            }
        }

        stage('Build') {
            steps {
                echo "Building.."
                sh "mvn clean install"
            }
        }
    }
}