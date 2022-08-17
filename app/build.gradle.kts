plugins {
    kotlin("android")
    id("kotlin-android")
    id("com.android.application")
}

android {
    compileSdk = Configuration.compileSDKVersion

    defaultConfig {
        applicationId             = "mobi.pulsus.challenge"
        minSdk                    = Configuration.minSDKVersion
        targetSdk                 = Configuration.targetSDKVersion
        versionCode               = Configuration.versionCode
        versionName               = Configuration.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled =  false
            proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility            = JavaVersion.VERSION_1_8
        targetCompatibility            = JavaVersion.VERSION_1_8
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Dependencies.Versions.Compose.compose
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":commons"))
    implementation(project(":network"))
    implementation(project(":cardservice:domain"))
    implementation(project(":cardservice:data"))
    implementation(project(":cardfeature"))

    implementation(Dependencies.Core.ktx)

    implementation(Dependencies.Compose.material)
    implementation(Dependencies.Compose.animations)
    implementation(Dependencies.Compose.compose)
    implementation(Dependencies.Compose.preview)
    implementation(Dependencies.Compose.viewmodel)
    implementation(Dependencies.Compose.navigation)


    testImplementation(Dependencies.Junit.junit)
    androidTestImplementation(Dependencies.Junit.extension)
    testImplementation(Dependencies.Mockk.mockk)
    androidTestImplementation(Dependencies.Mockk.android)
    androidTestImplementation(Dependencies.Compose.junit)

    coreLibraryDesugaring(Dependencies.Others.desugar)
}
