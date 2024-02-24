pluginManagement {
  repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
  }
}
dependencyResolutionManagement {
  repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
  repositories {
    google()
    mavenCentral()
  }
}

rootProject.name = "WinterSchool"
include(":app")
include(":features")
include(":features:auth")
include(":features:auth:api")
include(":features:auth:impl")
include(":features:news")
include(":features:news:api")
include(":features:news:impl")
