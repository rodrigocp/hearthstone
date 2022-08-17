object Plugins {
    val gradle by lazy { "com.android.tools.build:gradle:${Versions.gradle}" }
    val kotlin by lazy { "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}" }
    val hilt   by lazy { "com.google.dagger:hilt-android-gradle-plugin:${Versions.hilt}" }

    private object Versions {
        const val gradle = "7.2.2"
        const val kotlin = "1.7.0"
        const val hilt   = "2.38.1"
    }
}
