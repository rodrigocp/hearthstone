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

            buildConfigField("String", "API_KEY_NAME", "\"X-RapidAPI-Key\"")
            buildConfigField("String", "API_KEY_VALUE", "\"5c39d3a6cfmsh6fe90c3e729dea4p12dd74jsn7b615266bb73\"")

            buildConfigField("String", "API_HOST_NAME", "\"X-RapidAPI-Host\"")
            buildConfigField("String", "API_HOST_VALUE", "\"omgvamp-hearthstone-v1.p.rapidapi.com\"")
        }
        debug {
            buildConfigField("String", "BASE_URL", "\"https://omgvamp-hearthstone-v1.p.rapidapi.com/\"")
            buildConfigField("Long", "CACHE_SIZE", "102400L")

            buildConfigField("String", "API_KEY_NAME", "\"X-RapidAPI-Key\"")
            buildConfigField("String", "API_KEY_VALUE", "\"5c39d3a6cfmsh6fe90c3e729dea4p12dd74jsn7b615266bb73\"")

            buildConfigField("String", "API_HOST_NAME", "\"X-RapidAPI-Host\"")
            buildConfigField("String", "API_HOST_VALUE", "\"omgvamp-hearthstone-v1.p.rapidapi.com\"")
        }
    }
}

dependencies {
    implementation(project(":core"))
    implementation(project(":commons"))
    implementation(Dependencies.Core.ktx)
    implementation(Dependencies.Core.coroutines)

    implementation(Dependencies.Retrofit.retrofit)
    implementation(Dependencies.Retrofit.converter)
    implementation(Dependencies.Retrofit.logging)

    testImplementation(Dependencies.Junit.junit)
    androidTestImplementation(Dependencies.Junit.extension)
    testImplementation(Dependencies.Mockk.mockk)
    androidTestImplementation(Dependencies.Mockk.android)
    testImplementation(Dependencies.Others.json)
}
