def checkout(String branch, String repoUrl, String credentialsId) {
  checkout([
    $class: 'GitSCM',
    branches: [[name: "*/${branch}"]],
    userRemoteConfigs: [[
      url: repoUrl,
      credentialsId: credentialsId
    ]]
  ])
}