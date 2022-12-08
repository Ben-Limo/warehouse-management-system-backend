pipeline {
    agent {
        node {
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