pipeline {

    agent any

    environment {
        //Use Pipeline Utility Steps plugin to read information from pom.xml into env variables
        def archivePom = readMavenPom()

        ARTIFACT_ID = archivePom.getArtifactId()
        PROJECT_VERSION = archivePom.getVersion()

        def dockerImage = ""

    }
    
    tools {
        maven "MAVEN_HOME"
    }

    stages {
        stage('Build And Unit Test') {
            steps {
                sh "mvn clean install"
            }
        }

        stage('Analyze SonarQube') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh 'mvn clean verify sonar:sonar'
                }
            }
        }
    }
    
    post {
        success {
            junit '**/target/surefire-reports/TEST-*.xml'
            archiveArtifacts 'target/*.jar'
            slackSend message: "Build Success - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
        }
        failure {
            slackSend message: "Build Failure - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)"
        }
    }
}
