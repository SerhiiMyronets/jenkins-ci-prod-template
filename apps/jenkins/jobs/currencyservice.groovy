multibranchPipelineJob('currencyservice') {
  branchSources {
    github {
      id('currencyservice-github')
      repoOwner('organization_name')
      repository('currencyservice')
      scanCredentialsId('github-access-token')
    }
  }
  orphanedItemStrategy {
    discardOldItems {
      numToKeep(3)
    }
  }
}