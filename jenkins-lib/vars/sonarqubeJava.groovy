def scan(String projectName, String binaryPath) {
    withSonarQubeEnv('SonarQube') {
        sh """
            sonar-scanner \
            -Dsonar.projectName=${projectName} \
            -Dsonar.projectKey=${projectName} \
            -Dsonar.java.binaries=${binaryPath}
        """
    }
}
def qualityGate() {
    timeout(time: 1, unit: 'HOURS') {
        waitForQualityGate abortPipeline: true
    }
}