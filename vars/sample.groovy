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
            stage('Pipeline in Shared Lib Demo') {
                steps {
                   sh 'echo Declarative pipeline in shared lib'
                }
            stages('Test'){
                script {
                    sample.info 'Starting'
                    sample.warning 'Nothing to do,its warning only'
                }
            }

            }
        }//stages
    }//pipeline
}