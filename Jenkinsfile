/* Requires the Docker Pipeline plugin */
pipeline {
    agent { 
        docker {
            image 'maven:latest' 
            //becuse of error 'could not create local repository' we need to run as root user:
            //args '-u root'
            //or
            args '-v $HOME/.m2:/var/maven/.m2:z -e MAVEN_CONFIG=/var/maven/.m2 -e MAVEN_OPTS="-Duser.home=/var/maven"'
        }
    }
    
    parameters {
        string(name: 'Greeting', defaultValue: 'Zdravo', description: 'Linux')
    }
    
    stages {
        stage('build') {
            steps {
                //this is comment
                echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
                sh 'mvn --version'
                sh 'mvn clean test -Dbrowser="chrome" -e -X -Denv="qa" -Dsurefire.suiteXmlFiles=TestNGAnnotations.xml -Dresolution="middle"'
            }

        }
        stage('Publish Report') {
      steps {
        publishHTML([target: [
          allowMissing: false,
          alwaysLinkToLastBuild: true,
          keepAll: true,
          reportDir: 'target/surefire-reports/',
          reportFiles: 'index.html',
          reportName: "report"
        ]])
      }
    }
    }
    
    post {
        failure {
            echo "-----  FAIL -------"
        }
    }
}
