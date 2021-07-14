pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
    
}
rootProject.name = "tac-tic-toe"


include(":android")
include(":desktop")
include(":common")
include(":web")
include(":server:database")
include(":server")

