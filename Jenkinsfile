pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        bat 'C:\\Gradle\\gradle-5.6\\bin\\gradle build'
        bat 'C:\\Gradle\\gradle-5.6\\bin\\gradle javadoc'
        archiveArtifacts 'build/docs/* , build/*/*.jar'
      }
    }

    stage('Mail Notification') {
      steps {
        mail(to: 'ha_elfraihi@esi.dz', subject: "Pipeline: ${currentBuild.fullDisplayName}", body: "A new push has been executed, status of pipeline is: ${env.BUILD_URL} has result ${currentBuild.currentResult}")
      }
    }

    stage('Code Analysis') {
      parallel {
        stage('Code Analysis') {
          steps {
            bat 'C:\\Gradle\\gradle-5.6\\bin\\gradle sonarqube'
            waitForQualityGate true
          }
        }

        stage('Test reporting') {
          steps {
            cucumber '/*/*.json'
          }
        }

      }
    }

    stage('Deployment') {
      steps {
        bat 'C:\\Gradle\\gradle-5.6\\bin\\gradle publish'
      }
    }

    stage('Slack Notification') {
      steps {
        slackSend(channel: '#tp8_outils', token: 'T01NG34K5DE/B01SFE73YHL/9Sk7kGzSUUzud17mbW17t857', baseUrl: 'https://hooks.slack.com/services/', message: 'A new push has been executed !', teamDomain: 'esi', color: 'good')
      }
    }

  }
}