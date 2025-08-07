multibranchPipelineJob('adservice') {
  branchSources {
    github {
      id('adservice-github')
      repoOwner('DevSecOps-homelab')
      repository('adservice')
      scanCredentialsId('github-access-token')
    }
  }
  orphanedItemStrategy {
    discardOldItems {
      numToKeep(3)
    }
  }
}