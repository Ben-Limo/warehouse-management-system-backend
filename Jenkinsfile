pipeline {
    agent any

    tools {
        maven "maven-3.8.6"
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