
def buildImage(String buildkitAddr, String s3Endpoint, String serviceName) {
    sh """
        buildctl --addr=${buildkitAddr} build \
            --frontend=dockerfile.v0 \
            --local context=. \
            --local dockerfile=. \
            --export-cache type=s3,mode=max,name=${serviceName},endpoint_url=${s3Endpoint},use_path_style=true \
            --import-cache type=s3,name=${serviceName},endpoint_url=${s3Endpoint},use_path_style=true \
            --output type=oci,dest=image.tar
    """
}
def pushImage(String buildkitAddr, String s3Endpoint, String serviceName, String fullImage) {
    sh """
        buildctl --addr=${buildkitAddr} build \
            --frontend=dockerfile.v0 \
            --local context=. \
            --local dockerfile=. \
            --export-cache type=s3,mode=max,name=${serviceName},endpoint_url=${s3Endpoint},use_path_style=true \
            --import-cache type=s3,name=${serviceName},endpoint_url=${s3Endpoint},use_path_style=true \
            --output type=image,name=${fullImage},push=true
    """
}


def gitleaksScan(String outputFile = "fs-report.txt") {
    sh "gitleaks detect --source . --exit-code 1"
}