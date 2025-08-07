multibranchPipelineJob('paymentservice') {
  branchSources {
    github {
      id('paymentservice-github')
      repoOwner('DevSecOps-homelab')
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