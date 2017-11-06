node {

    def mvnHome = tool 'Maven'
    def app

    stage('Checkout and Test') {
        checkout scm
        sh "${mvnHome}/bin/mvn clean test"
    }

    stage('Build') {
        sh "${mvnHome}/bin/mvn -DskipTests package"
    }

    stage('Build Docker Image') {
        app = docker.build("pdincau/hello-java")
    }

    stage('UAT') {
        docker.image('pdincau/hello-java').withRun('-p 9999:8080') { c ->
            sh 'sleep 5'
            sh 'curl -v 127.0.0.1:9999/ping'
        }
    }

    stage('Publish Docker Image') {
        sh "docker push pdincau/hello-java"
        docker.withRegistry('https://registry.hub.docker.com', 'pdincau-credentials') {
            app.push("${env.BUILD_NUMBER}")
            app.push("latest")
        }
    }

}
