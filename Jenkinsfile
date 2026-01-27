pipeline {
    agent any

    tools {
        jdk 'jdk17'
        maven 'maven3'
    }

    parameters {
        choice(name: 'BROWSER', choices: ['chrome','firefox'], description: 'Choose browser')
    }

    stages {
        stage('Checkout Code') {
            steps {
                git url: 'https://github.com/dhaneshsk07/Cholickal.git', branch: "main"
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    sh "mvn clean test -DsuiteXmlFile=testng.xml -Dbrowser=${params.BROWSER}"
                }
            }
        }

        stage('Publish Reports') {
            steps {
                publishHTML([
                    reportDir: 'target/surefire-reports',
                    reportFiles: 'index.html',
                    reportName: 'TestNG Report',
                    keepAll: true,
                    alwaysLinkToLastBuild: true
                ])
            }
        }
    }

    post {
        always {
            echo "Pipeline completed for branch main"
        }
        failure {
            echo "Tests failed!"
        }
    }
}
