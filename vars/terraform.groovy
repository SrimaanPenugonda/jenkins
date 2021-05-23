def call(string action){
    if(action == "apply"){
        pipeline{
            agent any

            tools{ //Global Tool call
                terraform 'Terraform14.3'
            }
            environment { //Manage Credentials
                AWS = credentials('AWS')
            }
            parameters {
                choice(name: 'ENV', choices: ['', 'dev', 'prod'], description: 'Pick Environment')
            }
            stages{
                stage('INIT'){
                    steps{
                        sh ''' 
              export AWS_ACCESS_KEY_ID=${AWS_USR}
              export AWS_SECRET_ACCESS_KEY=${AWS_PSW}
              export TF_VAR_APP_ARTIFACT_VERSION="*"  
              make ${ENV}-init  
            '''
                    }
                }//INIT
                stage('APPLY'){
                    steps{
                        sh ''' 
              export AWS_ACCESS_KEY_ID=${AWS_USR}
              export AWS_SECRET_ACCESS_KEY=${AWS_PSW}
              export TF_VAR_APP_ARTIFACT_VERSION="*"  
              make ${ENV}-apply  
            '''
                    }
                }//APPLY
            }//stages
        }//pipeline
    }//if
}//call