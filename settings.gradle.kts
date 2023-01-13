import java.util.Locale

pluginManagement {
    repositories {
        maven("https://papermc.io/repo/repository/maven-public/")
        gradlePluginPortal()
        mavenCentral()
    }

    plugins {
        id("com.github.johnrengelman.shadow") version "7.1.2" apply false
        id("io.papermc.paperweight.patcher") version "1.3.11"
    }
}

rootProject.name = "quill"
for (name in listOf("Quill-API", "Quill-Server")) {
    val projName = name.toLowerCase(Locale.ENGLISH)
    include(projName)
    findProject(":$projName")?.projectDir = file(name)
}