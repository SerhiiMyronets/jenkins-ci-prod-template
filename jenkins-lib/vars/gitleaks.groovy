def scan(String outputFile = "fs-report.txt") {
    sh "gitleaks detect --source . --exit-code 1"
}