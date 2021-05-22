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


Only entire pipelines can be defined in shared libraries as of this time. This can only be done in vars/*.groovy, and only in a call method. Only one Declarative Pipeline can be executed in a single build, and if you attempt to execute a second one, your build will fail as a result.
