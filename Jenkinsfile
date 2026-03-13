pipeline {
    agent any
    
    // Inject the Maven tool we configured in Jenkins earlier
    tools {
        maven 'Maven-3' 
    }

    stages {
        stage('Build') {
            steps { bat 'mvn clean compile' }
        }
        stage('Test') {
            steps { bat 'mvn test' }
        }
        stage('Package') {
            steps { bat 'mvn package -DskipTests' }
        }
        stage('Docker Build') {
            steps { bat 'docker build -t myapp:latest .' }
        }
        stage('Deploy') {
            steps {
                // The '|| exit 0' prevents the pipeline from failing on the first run 
                // when the container doesn't exist to be stopped/removed yet.
                bat 'docker stop myapp-container || exit 0'
                bat 'docker rm myapp-container || exit 0'
                bat 'docker run -d --name myapp-container -p 8081:8081 myapp:latest'
            }
        }
    }
    post {
        success { echo 'Pipeline completed successfully!' }
        failure  { echo 'Pipeline failed. Check logs.' }
    }
}