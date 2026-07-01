pipeline {
    agent any
    tools {
        maven "maven"
    }
    stages {
        stage("Scm Checkout") {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/Sureshgangula8/springdemojenkincicd.git']])
            }
        }
        stage("Build process") {
            steps {
                script {
                    bat "mvn clean install"
                }
            }
        }
        stage("deploy war") {
            steps {
                deploy adapters: [tomcat9(alternativeDeploymentContext: '', credentialsId: 'tomact_pwd', path: '', url: 'http://localhost:8080/')], contextPath: 'jenkinsCICD', war: '**/*.war'
            }
        }
    }
    post {
        always {
            emailext attachLog: true, body: '''<html><body>
            <p>Build Status: ${BUILD_STATUS}</p>
            <p>Build Number: ${BUILD_NUMBER}</p>
            <p>Check the <a href="${BUILD_URL}">Console output</a></p>
            </body></html>''', mimeType: 'text/html', replyTo: 'sureshgangula8@gmail.com', subject: 'Jenkins Pipeline Status : ${BUILD_NUMBER}', to: 'sureshgangula8@gmail.com'
        }
    }
}