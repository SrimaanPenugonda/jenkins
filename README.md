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


