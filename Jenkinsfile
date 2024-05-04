
/* Requires the Docker Pipeline plugin */
pipeline {
    agent { 
        docker {
            image 'maven:latest' 
        }
    }
    
    
    environment { 
        BUILD_ID = 55
    }
    parameters {
        string(name: 'Greeting', defaultValue: 'Zdravo', description: 'Linux')
    }
    
    stages {
        stage('build') {
            environment { 
                BUILD_ID = 446
            }
            steps {
                //this is comment
                echo "Running ${env.BUILD_ID} on ${env.JENKINS_URL}"
                //sh 'mvn --version'
                sh 'printenv'
            }

        }
        stage('Example') {
            steps {
                echo "${params.Greeting} Maven!"
            }
        }
    }
    
    post {
        always {
            echo "-----  END -------"
        }
        failure {
            echo "-----  FAIL -------"
        }
    }
}
