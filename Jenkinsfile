pipeline {
    // Defines the agent (where the build runs). 'any' uses any available Jenkins agent.
    // For Maven, ensure your agent has Java and Maven installed.
    agent any 

    // Environment variables can be defined here if needed for credentials or paths
    environment {
        // Define the email recipient
        REPORT_EMAIL_RECIPIENT = 'dineshnimmala02@gmail.com' 
    }

    stages {
        // --- Stage 1: Clone the Code ---
        stage('Checkout Code') {
            steps {
                // When using 'Pipeline script from SCM' in job config, 
                // the 'git clone' is performed automatically *before* the first stage.
                // This step confirms the successful checkout.
                echo 'Source code successfully cloned from GitHub.'
                // You can add steps here if you need to specifically handle LFS or submodules:
                // checkout scm
            }
        }

        // --- Stage 2: Execute Maven Build and Verification ---
        stage('Build and Test (Maven)') {
            steps {
                echo 'Executing Maven build and verification...'
                // Assumes 'mvn' is available on the Jenkins agent's PATH.
                // 'clean verify' compiles, runs tests, and generates reports.
                bat 'mvn clean verify' 
                echo 'Maven build and verification complete. Reports generated in the target folder.'
            }
        }

        // --- Stage 3: Export/Mail the Report ---
        stage('Publish Report') {
            steps {
                echo 'Attempting to archive and email the test report...'
                
                // 1. Archive the Test Results (Optional, but good practice)
                // This makes the report files available on the Jenkins build page.
                // Assumes Surefire/Failsafe reports are in the standard XML format.
                // You may need to install the JUnit plugin for this step.
                junit '**/target//*.xml' 
                
                // 2. Archive the HTML Report (e.g., test coverage or static analysis)
                // This makes a specific file available as a downloadable artifact.
                // archiveArtifacts artifacts: 'target/site/jacoco/jacoco.csv, target/**/*.html', onlyIfSuccessful: true
                
                // 3. Email the Report (Requires Jenkins Email Extension Plugin)
                // This step uses environment variable defined above.
                mail bcc: '', 
                     body: "The Jenkins build #${currentBuild.number} for project ${env.JOB_NAME} has completed.\n\n" +
                           "Test results and artifacts are available at: ${env.BUILD_URL}",
                     from: 'nimmaladinesh5@gmail.com',
                     subject: "SUCCESS: Build #${currentBuild.number} Report", 
                     to: env.REPORT_EMAIL_RECIPIENT
            }
        }
    }
    // --- Post-Build Actions (Cleanup or Notification) ---
    post {
        always {
            echo 'Pipeline finished. Cleaning up workspace...'
            // cleanWs() // Uncomment this line to clean the workspace after every build
        }
        failure {
            // Send a specific email if the build fails
            mail subject: "FAILURE: Build #${currentBuild.number} Failed", 
                 to: env.REPORT_EMAIL_RECIPIENT,
                 body: "The Jenkins build #${currentBuild.number} has failed. Check the console log: ${env.BUILD_URL}/console"
        }
    }
}