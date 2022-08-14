object Dependencies {
    val coreKTX               by lazy { "androidx.core:core-ktx:${Versions.coreKTX}" }
    val kotlinCoroutinesCore  by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutinesCore}" }
    val composeUI             by lazy { "androidx.compose.ui:ui:${Versions.compose}" }
    val composeToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.compose}" }
    val material3             by lazy { "androidx.compose.material3:material3:${Versions.material3}" }
    val animations            by lazy { "androidx.compose.animation:animation:${Versions.compose}" }
    val composeViewModel      by lazy { "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.composeViewModel}" }
    val koinCompose           by lazy { "io.insert-koin:koin-androidx-compose:${Versions.koin}" }
    val composeNavigation     by lazy { "androidx.navigation:navigation-compose:${Versions.composeNavigation}" }
    val coil                  by lazy { "io.coil-kt:coil-compose:${Versions.coil}" }

    val retrofit              by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
    val gson                  by lazy { "com.google.code.gson:gson:${Versions.gson}" }
    val gsonConverter         by lazy { "com.squareup.retrofit2:converter-gson:${Versions.gsonConverter}" }
    val loggingInterceptor    by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.loggingInterceptor}" }

    val koin                  by lazy { "io.insert-koin:koin-android:${Versions.koin}" }

    // Tests
    val junit                 by lazy { "junit:junit:${Versions.junit}" }
    val androidJunitExt       by lazy { "androidx.test.ext:junit:${Versions.androidJunitExt}" }
    val androidEspressoCore   by lazy { "androidx.test.espresso:espresso-core:${Versions.androidEspressoCore}" }
    val androidJunitCompose   by lazy { "androidx.compose.ui:ui-test-junit4:${Versions.compose}" }
    val mockk                 by lazy { "io.mockk:mockk:${Versions.mockk}" }
    val mockkAndroid          by lazy { "io.mockk:mockk-android:${Versions.mockk}" }

    // Debug
    val composeToolingDebug   by lazy { "androidx.compose.ui:ui-tooling:${Versions.compose}" }
    val composeUiTestManifest by lazy { "androidx.compose.ui:ui-test-manifest:${Versions.compose}" }

    // Others
    val desugar               by lazy { "com.android.tools:desugar_jdk_libs:${Versions.desugar}" }
}
