def call() {
    def scannerFile = 'sysdig-cli-scanner'
    def sysdigUrl = 'https://download.sysdig.com/scanning/bin/sysdig-cli-scanner/$(curl -sL https://download.sysdig.com/scanning/sysdig-cli-scanner/latest_version.txt)/linux/amd64/sysdig-cli-scanner'
    def sysdigApiUrl = 'https://app.us4.sysdig.com'
    def dockerImage = 'nginx:latest'

    if (!fileExists(scannerFile)) {
        echo "Downloading Sysdig CLI Scanner..."
        sh """
            curl -sL -o ${scannerFile} ${sysdigUrl}
            chmod +x ${scannerFile}
        """
    } else {
        echo "Sysdig CLI Scanner already exists. Skipping download."
    }

    sh """
        ./${scannerFile} --apiurl ${sysdigApiUrl} --console-log ${dockerImage} || true
    """
}
