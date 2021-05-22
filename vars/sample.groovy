def info(message) {
    echo "INFO: ${message}"
}

def warning(message) {
    echo "WARNING: ${message}"
}

def call() {
    pipeline {
        agent any

        stages {
            stage('Shared Lib Demo') {
                steps {
                    script {
                        sample.info 'Starting'
                        sample.warning 'Nothing to do,its warning only'
                    }
                }
            }
        }//stages
    }//pipeline
}