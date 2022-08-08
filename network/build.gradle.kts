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

    buildTypes {
        release {
            buildConfigField("String", "BASE_URL", "\"https://omgvamp-hearthstone-v1.p.rapidapi.com/\"")
            buildConfigField("Long", "CACHE_SIZE", "102400L")
        }
        debug {
            buildConfigField("String", "BASE_URL", "\"https://omgvamp-hearthstone-v1.p.rapidapi.com/\"")
            buildConfigField("Long", "CACHE_SIZE", "102400L")
        }
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":commons"))
    implementation(Dependencies.coreKTX)
    implementation(Dependencies.kotlinCoroutinesCore)
    implementation(Dependencies.moshiKotlin)
    implementation(Dependencies.moshiConverter)
    implementation(Dependencies.loggingInterceptor)
    implementation(Dependencies.koin)

    testImplementation(Dependencies.junit)
    testImplementation(Dependencies.mockk)
    androidTestImplementation(Dependencies.mockkAndroid)
    androidTestImplementation(Dependencies.androidJunitExt)
}
