pipeline {
    agent any
    
    triggers {
        githubPush()
    }

    tools {
        jdk 'jdk17'
        maven 'maven3'
    }

    parameters {
        choice(name: 'BROWSER', choices: ['chrome','firefox'], description: 'Choose browser')
    }

    environment {
        REPORT_DIR = "test-output"
    }

    stages {
        stage('Checkout Code') {
            steps {
                git url: 'https://github.com/dhaneshsk07/Cholickal.git', branch: "main"
            }
        }

        stage('Run Tests') {
            steps {
                sh "mvn clean test -DsuiteXmlFile=testng.xml -Dbrowser=${params.BROWSER}"
            }
        }

        stage('Publish Extent Report') {
            steps {
                publishHTML([
                    reportDir: "${REPORT_DIR}",
                    reportFiles: 'ExtentReport_*.html',
                    reportName: 'Extent Automation Report',
                    keepAll: true,
                    alwaysLinkToLastBuild: true,
                    allowMissing: false
                ])
            }
        }
    }

    post {
        always {
            echo "Pipeline completed for branch main"
        }
        failure {
            echo "Tests failed! Check Extent Report in Jenkins."
        }
    }
}
