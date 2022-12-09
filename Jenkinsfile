pipeline {
    agent {
        docker {
            image "3.8.6-openjdk-18"
        }
    }

    stages {
        stage('Check Environment') {
                steps {
                    echo "checking environment .."
                    sh "mvn -version"
                    sh "java -version"
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