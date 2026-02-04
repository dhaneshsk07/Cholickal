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
        choice(name: 'BROWSER', choices: ['chrome', 'firefox'], description: 'Choose browser')
    }

    environment {
        REPORT_DIR = "test-output"
    }

    stages {

        stage('Checkout Code') {
            steps {
                git url: 'https://github.com/dhaneshsk07/Cholickal.git', branch: 'main'
            }
        }

        stage('Run Tests') {
            steps {
                // Allow pipeline to continue even if tests fail
                catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                    sh "mvn clean test -DsuiteXmlFile=testng.xml -Dbrowser=${params.BROWSER}"
                }
            }
        }
    }

    post {
        always {
            echo "Publishing Extent Report (PASS or FAIL)"

            publishHTML([
                reportDir: "${REPORT_DIR}",
                reportFiles: 'ExtentReport_*.html',
                reportName: 'Extent Automation Report',
                keepAll: true,
                alwaysLinkToLastBuild: true,
                allowMissing: false
            ])
        }

        failure {
            echo "Tests failed! See Extent Automation Report above."
        }

        success {
            echo "Tests passed successfully."
        }
    }
}
