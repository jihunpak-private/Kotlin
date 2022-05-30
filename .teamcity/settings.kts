import jetbrains.buildServer.configs.kotlin.*
import jetbrains.buildServer.configs.kotlin.buildSteps.script
import jetbrains.buildServer.configs.kotlin.triggers.vcs
import jetbrains.buildServer.configs.kotlin.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2022.04"

project {

    vcsRoot(HttpsGithubComJihunpakPrivateKotlinRefsHeadsMain)

    buildType(Build)
}

object Build : BuildType({
    name = "Build"

    vcs {
        root(HttpsGithubComJihunpakPrivateKotlinRefsHeadsMain)
    }

    steps {
        script {
            name = "test"
            scriptContent = "ls"
        }
    }

    triggers {
        vcs {
        }
    }
})

object HttpsGithubComJihunpakPrivateKotlinRefsHeadsMain : GitVcsRoot({
    name = "https://github.com/jihunpak-private/Kotlin.git#refs/heads/main"
    url = "https://github.com/jihunpak-private/Kotlin.git"
    branch = "refs/heads/main"
    branchSpec = "refs/heads/*"
    authMethod = password {
        userName = "jihunpak"
        password = "credentialsJSON:82858e1d-9bc2-4c98-9905-d60630a79f99"
    }
})
