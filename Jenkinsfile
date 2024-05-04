/* Requires the Docker Pipeline plugin */
pipeline {
    agent { 
        docker {
            image 'maven:latest' 
            // args '-v /root/.m2:/root/.m2' //here you can map local maven repo, this let you to reuse local artifacts
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
                sh 'mvn clean test -Dbrowser="chrome" -Denv="qa" -Dsurefire.suiteXmlFiles=TestNGAnnotations.xml -Dresolution="middle"'
            }

        }
        stage('Publish Report') {
      steps {
        publishHTML([target: [
          allowMissing: false,
          alwaysLinkToLastBuild: true,
          keepAll: true,
          reportDir: 'target/surefire-reports/html/',
          reportFiles: 'index.html',
          reportName: "report"
        ]])
      }
    }
    }
    
    post {
        always {
            //junit '**/target/surefire-reports/TEST-*.xml'
        }
        failure {
            echo "-----  FAIL -------"
        }
    }
}
