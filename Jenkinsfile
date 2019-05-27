pipeline {
    agent { docker { image 'gradle:5.0.0-jdk8' } }
    stages {
        stage('build') {
            steps {
                sh 'gradle build'
            }
        }
    }
}