# jenkins
s52: jenkins installation 
sudo rpm
https://pkg.jenkins.io/redhat-stable/
sudo wget -O /etc/yum.repos.d/jenkins.repo https://pkg.jenkins.io/redhat-stable/jenkins.repo
sudo rpm --import https://pkg.jenkins.io/redhat-stable/jenkins.io.key

sudo yum install jenkins java -y
netstat -lntp
tcp6       0      0 :::8080                 :::*                    LISTEN      3273/java

ipaddress:8080 - jenkins page
/var/lib/jenkins/secrets/initialAdminPassword - pwd

jenkins use public ip of server

anything can be managed by plugins in jenkins
managed plugins - install git,ansi colour if not there.. like that

Blue Ocean - fundamentally for pipelines

pipeline syntax:
https://www.jenkins.io/doc/book/pipeline/syntax/

Groove Code:
pipeline{
  agent any
   stages {
     stage('One'){
       steps {
          sh 'echo Welcome to stage One'
}
}
}
}

Jenkins Shared Lib:
sample is one of the shared library - sample.groovy
mange plugins- globoal configuraion system - Global Pipeline Lib-
roboshop
default version : main
modern SCM
and save it

@Library('roboshop') _

pipeline{
agent any

    stages{
        stage('Shared Lib Demo'){
            steps {
                script {
                    sample.info 'Starting'
                    sample.warning 'Nothing to do,its warning only'
                }
            }
        }
    }//stages
}//pipeline

The vars directory hosts script files that are exposed as a variable in Pipelines. The name of the file is the name of the variable in the Pipeline. So if you had a file called vars/log.groovy with a function like def info(message)…​ in it, you can access this function like log.info "hello world" in the Pipeline. You can put as many functions as you like inside this file. Read on below for more examples and options.

Only entire pipelines can be defined in shared libraries as of this time. This can only be done in vars/*.groovy, and only in a call method. Only one Declarative Pipeline can be executed in a single build, and if you attempt to execute a second one, your build will fail as a result.

- To automate the INFRA creation -
 create a terraform.grrovy file under vars.. 
  with action argument...
  INIT
  APPLY
  
call this groovy file in all components.. terraform-vpc
Jenkinsfile - Script where invoked the library
@Library('roboshop') _ 
terraform("action")

copy same Jenkinsfile script to all coponents and run.

To automate the job creation 
create a seed folder and roboshop.groovy file
///
folder('Roboshop-Releases') {
displayName('Roboshop-Releases')
description('Roboshop-Releases')
}

pipelineJob('Roboshop-Releases/VPC') {
configure { flowdefinition ->
flowdefinition << delegate.'definition'(class:'org.jenkinsci.plugins.workflow.cps.CpsScmFlowDefinition',plugin:'workflow-cps') {
'scm'(class:'hudson.plugins.git.GitSCM',plugin:'git') {
'userRemoteConfigs' {
'hudson.plugins.git.UserRemoteConfig' {
'url'('https://github.com/SrimaanPenugonda/terraform-vpc.git')
}
}
'branches' {
'hudson.plugins.git.BranchSpec' {
'name'('*/main')
}
}
}
'scriptPath'('Jenkinsfile')
'lightweight'(true)
}
}
}

configure this groovy file - create a job seed.. freestyle 
SCM - give jenkins git
BUILD - Process job DSLs
give seed/roboshop.groovy at DSL script and save and run this
it create Roboshop-Release folder and VPC job under it

S55:
Create a wraper jenkins file - to create a total infra automatically
Maven Project Configuration - # of executors - 5