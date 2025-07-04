pipeline {
    agent any

    stages {
        stage('Obtenção do código no Github') {
            steps {
                git branch: 'main', 
                url: 'https://github.com/MarquesLazaro/GC_Atividade_Jenkins.git'
            }
        }

        stage('Criação do container Docker para o build') {
            steps {
                bat 'docker run --rm -v "%cd%":/app -w /app maven:3.9-eclipse-temurin-17 mvn clean package -DskipTests -Dmaven.clean.failOnError=false'
                archiveArtifacts artifacts: 'target\\*.jar'
            }
        }

        stage('Criação do container Docker para o teste') {
            steps {
                script {
                    try {
                        bat 'docker run --rm -v "%cd%":/app -w /app maven:3.9-eclipse-temurin-17 mvn test'
                    } catch (Exception e) {
                        echo "ALERTA: Alguns testes falharam: ${e.getMessage()}"
                    }
                    
                    junit 'target\\surefire-reports\\**\\*.xml'
                    archiveArtifacts artifacts: 'target\\surefire-reports\\**\\*'
                }
            }
        }
    }

}
