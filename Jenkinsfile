pipeline { 

agent any 

environment { 

AWSREGION = 'us-east-1' 

ECRREPO = '854681582780.dkr.ecr.us-east-1.amazonaws.com/java_demo' 

} 

stages { 

stage('Checkout Code') { 

steps { 



                git 'https://github.com/urvy/java_demo2.git' 

            } 

        } 

        stage('Build with Maven') { 

            steps { 

                sh 'mvn clean install' 

            } 

        } 

        stage('Generate JAR') { 

            steps { 

                echo 'JAR generated in target directory' 

            } 

        } 

        stage('Build Docker Image') { 

            steps { 

                sh 'docker build -t my-app .' 

            } 

        } 

        stage('Login to AWS ECR') { 

            steps { 

                sh 'aws ecr get-login-password --region $AWSREGION | docker login --username AWS -

password-stdin $ECRREPO' 

            } 

        } 

        stage('Tag & Push Docker Image') { 

            steps { 

                sh 'docker tag my-app:latest $ECRREPO:latest' 

                sh 'docker push $ECRREPO:latest' 

            } 

        } 
