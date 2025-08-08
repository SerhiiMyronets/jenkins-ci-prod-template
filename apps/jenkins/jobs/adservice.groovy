multibranchPipelineJob('adservice') {
  branchSources {
    github {
      id('adservice-github')
      repoOwner('organization_name')
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