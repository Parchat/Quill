import java.util.Locale

pluginManagement {
    repositories {
        maven("https://papermc.io/repo/repository/maven-public/")
        gradlePluginPortal()
        mavenCentral()
    }
}

rootProject.name = "Quill"
for (name in listOf("Quill-API", "Quill-Server")) {
    val projName = name.toLowerCase(Locale.ENGLISH)
    include(projName)
    findProject(":$projName")?.projectDir = file(name)
}