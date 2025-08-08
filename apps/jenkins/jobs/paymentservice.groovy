multibranchPipelineJob('paymentservice') {
  branchSources {
    github {
      id('paymentservice-github')
      repoOwner('organization_name')
      repository('paymentservice')
      scanCredentialsId('github-access-token')
    }
  }
  orphanedItemStrategy {
    discardOldItems {
      numToKeep(3)
    }
  }
}