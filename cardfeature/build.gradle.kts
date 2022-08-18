plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
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

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Versions.Compose.compose
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility            = JavaVersion.VERSION_1_8
        targetCompatibility            = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":commons"))
    implementation(project(":cardservice:domain"))

    implementation(Dependencies.Core.ktx)
    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.animations)
    implementation(Dependencies.Compose.compose)
    implementation(Dependencies.Compose.preview)
    implementation(Dependencies.Compose.viewmodel)
    implementation(Dependencies.Compose.navigation)
    implementation(Dependencies.Others.coil)
    implementation(Dependencies.Others.gson)
    implementation(Dependencies.Hilt.android)
    implementation(Dependencies.Hilt.navigation)

    kapt(Dependencies.Hilt.compiler)

    testImplementation(Dependencies.Junit.junit)
    androidTestImplementation(Dependencies.Junit.extension)
    testImplementation(Dependencies.Mockk.mockk)
    androidTestImplementation(Dependencies.Mockk.android)
    androidTestImplementation(Dependencies.Compose.junit)

    coreLibraryDesugaring(Dependencies.Others.desugar)
}
