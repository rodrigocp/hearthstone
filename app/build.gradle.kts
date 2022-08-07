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

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Versions.compose
    }
}

dependencies {
    implementation(Dependencies.coreKTX)
    implementation(Dependencies.composeUI)
    implementation(Dependencies.material3)
    implementation(Dependencies.composeToolingPreview)
    implementation(Dependencies.lifecycleRuntimeKTX)
    implementation(Dependencies.composeActivity)

    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.mockk)
    androidTestImplementation(Dependencies.mockkAndroid)
    androidTestImplementation(Dependencies.androidJunitExt)
    androidTestImplementation(Dependencies.androidEspressoCore)
    androidTestImplementation(Dependencies.androidJunitCompose)

    debugImplementation(Dependencies.composeToolingDebug)
    debugImplementation(Dependencies.composeUiTestManifest)

    coreLibraryDesugaring(Dependencies.desugar)
}
