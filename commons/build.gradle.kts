plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    compileSdk = Configuration.compileSDKVersion

    defaultConfig {
        minSdk                    = Configuration.minSDKVersion
        targetSdk                 = Configuration.targetSDKVersion
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled =  false
            consumerProguardFile("consumer-rules.pro")
        }
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility            = JavaVersion.VERSION_1_8
        targetCompatibility            = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(project(":core"))

    implementation(Dependencies.Core.ktx)

    testImplementation(Dependencies.Junit.junit)
    androidTestImplementation(Dependencies.Junit.extension)
    testImplementation(Dependencies.Mockk.mockk)
    androidTestImplementation(Dependencies.Mockk.android)
}
