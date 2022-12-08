pipeline {
    agent {
        docker {
            image "3.8.6-openjdk-18"
            label "docker-agent-maven"
        }
    }

    stages {
        stage('Build') {
            steps {
                echo "Building.."
                sh "mvn -version"
                sh "mvn clean install"
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}