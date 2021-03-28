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

  }
}