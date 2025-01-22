pipeline {
        agent any
        stages {
                stage('Build') {
                        steps {
                                checkout([$class: 'GitSCM', branches: [[name: '*/master']], doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [], userRemoteConfigs: [[url: '']]])
                   }
                }
                stage('Test') {
                        steps {
                                bat 'mvn test "-Dsurefire.suiteXmlFiles=testSuites/Purchase.xml"'
                        }
                }
        }
}