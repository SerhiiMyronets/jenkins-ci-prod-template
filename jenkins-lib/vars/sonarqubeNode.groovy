def scan(String projectName) {
    withSonarQubeEnv('SonarQube') {
        sh """
            sonar-scanner \
            -Dsonar.projectName=${projectName} \
            -Dsonar.projectKey=${projectName}
        """
    }
}
def qualityGate() {
    timeout(time: 1, unit: 'HOURS') {
        waitForQualityGate abortPipeline: true
    }
}