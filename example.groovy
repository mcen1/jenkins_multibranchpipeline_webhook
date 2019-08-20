// I didn't see this anywhere online and I figure I'd save someone else the trouble of digging through the API.
// This is the DSL to create a multi-branch pipeline that utilizes the webhook 
// trigger plugin from from https://wiki.jenkins.io/display/JENKINS/Pipeline+Multibranch+Plugin
// It'll set a token of token123 you can call to trigger the scan
def gitUrl = "https://github.com/project"
multibranchPipelineJob("subfolder/jobname") {
  triggers {
      computedFolderWebHookTrigger {
        token('token123')
      }
  }
  branchSources {
    git {
      remote(gitUrl)
      id('12345')
      credentialsId('jenkinscreds')
    }
  }
}
