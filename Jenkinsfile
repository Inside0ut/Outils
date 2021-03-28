pipeline {
  agent any
  stages {
    stage('Build') {
      steps {
        bat 'C:\\Gradle\\gradle-5.6\\bin\\gradle build'
        bat 'C:\\Gradle\\gradle-5.6\\bin\\gradle javadoc'
        archiveArtifacts 'build/docs/* , build/*/*.jar'
      }
      stage('Mail Notification'){
        post {
          failure{
            mail(subject: "notification: BUILD FAILURE", body: " le Build a echoué",to: "ha_elfraihi@esi.dz, hs_boushaba@esi.dz" )
          }
          success{
            mail(subject: "notification: BUILD SUCCESSFUL", body: " build exécutée en succes",to: "ha_elfraihi@esi.dz, hs_boushaba@esi.dz" )
          }
        }
        
      }
    }

  }
}
