// vars/sysdigScanWrapper.groovy
// This function encapsulates the new SysDig scan logic
def call(Map config) {
    // Define default values for parameters
    def credentialsId = config.engineCredentialsId ?: 'sysdig-secure-api-credentials'
    def imageName = config.imageName

    if (!imageName) {
        error "SysDig Scan Wrapper: 'imageName' parameter is required."
    }

    echo "Starting SysDig Image Scan using new plugin syntax for image: ${imageName}"

    // This is where the new Sysdig plugin step is called
    sysdigImageScan(
        engineCredentialsId: credentialsId,
        imageName: imageName
    )

    echo "SysDig Image Scan completed successfully."
}
