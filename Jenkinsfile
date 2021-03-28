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
        mail(to: 'hs_boushaba@esi.dz', subject: "Pipeline: ${currentBuild.fullDisplayName}", body: "Something is wrong with ${env.BUILD_URL} has result ${currentBuild.result}")
      }
    }

  }
}