def call(Map args = [:]) {
    def imageListFile = args.name ?: 'sysdig_secure_images'
    def imageName = ''

    // Read the image ID from the file written earlier in the pipeline
    if (fileExists(imageListFile)) {
        imageName = readFile(imageListFile).trim()
    }

    // Call the new plugin method
    sysdigImageScan(
        engineCredentialsId: args.engineCredentialsId,
        imageName: imageName
    )
}
