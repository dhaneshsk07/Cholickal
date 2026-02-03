pipeline {
    agent any

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

        stage('Rename Extent Report with Timestamp') {
            steps {
                script {
                    def timestamp = sh(
                        script: "date +%Y%m%d_%H%M%S",
                        returnStdout: true
                    ).trim()

                    env.EXTENT_REPORT = "ExtentReport_${timestamp}.html"

                    sh """
                        mv ${REPORT_DIR}/ExtentReport.html \
                           ${REPORT_DIR}/${EXTENT_REPORT}
                    """
                }
            }
        }

        stage('Publish Extent Report') {
            steps {
                publishHTML([
                    reportDir: "${REPORT_DIR}",
                    reportFiles: "${EXTENT_REPORT}",
                    reportName: "Extent Automation Report",
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
            echo "Tests failed! Check timestamped Extent report in Jenkins."
        }
    }
}
