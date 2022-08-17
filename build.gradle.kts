buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(Plugins.gradle)
        classpath(Plugins.kotlin)
        classpath(Plugins.hilt)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}

tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}
