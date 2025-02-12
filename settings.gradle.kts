import java.net.URI

include(":domain:usecase")


pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = URI("https://jitpack.io") }

    }
}
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "WeatherApp"
include(":app")
include(":feature:home")
include(":feature:search")
include(":core:utils")
include(":core:ui")
include(":core:data-store")
include(":core:data-base")
include(":core:model")
include(":core:data")
include(":core:common")
include(":core:network")
include(":feature:settings")

