object Dependencies {
    val coreKTX               by lazy { "androidx.core:core-ktx:${Versions.coreKTX}" }
    val kotlinCoroutinesCore  by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinCoroutinesCore}" }
    val lifecycleRuntimeKTX   by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleRuntimeKTX}" }
    val composeUI             by lazy { "androidx.compose.ui:ui:${Versions.compose}" }
    val composeActivity       by lazy { "androidx.activity:activity-compose:${Versions.composeActivity}" }
    val composeToolingPreview by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.compose}" }
    val material3             by lazy { "androidx.compose.material3:material3:${Versions.material3}" }

    val moshiKotlin           by lazy { "com.squareup.moshi:moshi-kotlin:${Versions.moshiKotlin}" }
    val moshiConverter        by lazy { "com.squareup.retrofit2:converter-moshi:${Versions.moshiConverter}" }
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
