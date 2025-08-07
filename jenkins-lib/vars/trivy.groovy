def filesystemScan(String outputFile = "fs-report.txt") {
    sh "trivy fs --format table -o ${outputFile} ."
}
def imageScan(String imageTarName = "image.tar", String outputFile = "image-report.txt") {
    sh """
        mkdir -p image-dir
        tar -xf ${imageTarName} -C image-dir
        trivy image --input image-dir --format table -o ${outputFile}
    """
}
