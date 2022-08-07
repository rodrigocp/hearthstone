plugins {
    kotlin("android")
    id("com.android.library")
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
    implementation(Dependencies.coreKTX)
    implementation(Dependencies.kotlinCoroutinesCore)
    implementation(Dependencies.moshiKotlin)
    implementation(Dependencies.moshiConverter)
    implementation(Dependencies.loggingInterceptor)

    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.mockk)
    androidTestImplementation(Dependencies.mockkAndroid)
    androidTestImplementation(Dependencies.androidJunitExt)
}
