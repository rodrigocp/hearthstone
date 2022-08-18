object Dependencies {
    object Core {
        val ktx        by lazy { "androidx.core:core-ktx:${Versions.Core.ktx}" }
        val coroutines by lazy { "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Core.coroutines}" }
    }

    object Compose {
        val compose    by lazy { "androidx.compose.ui:ui:${Versions.Compose.compose}" }
        val animations by lazy { "androidx.compose.animation:animation:${Versions.Compose.compose}" }
        val preview    by lazy { "androidx.compose.ui:ui-tooling-preview:${Versions.Compose.compose}" }
        val viewmodel  by lazy { "androidx.lifecycle:lifecycle-viewmodel-compose:${Versions.Compose.viewmodel}" }
        val navigation by lazy { "androidx.navigation:navigation-compose:${Versions.Compose.navigation}" }
        val material   by lazy { "androidx.compose.material3:material3:${Versions.Compose.material}" }
        val junit      by lazy { "androidx.compose.ui:ui-test-junit4:${Versions.Compose.compose}" }
    }

    object Hilt {
        val android    by lazy { "com.google.dagger:hilt-android:${Versions.Hilt.hilt}" }
        val compiler   by lazy { "com.google.dagger:hilt-android-compiler:${Versions.Hilt.hilt}" }
        val navigation by lazy { "androidx.hilt:hilt-navigation-compose:${Versions.Hilt.navigation}" }
    }

    object Retrofit {
        val retrofit  by lazy { "com.squareup.retrofit2:retrofit:${Versions.Retrofit.retrofit}" }
        val logging   by lazy { "com.squareup.okhttp3:logging-interceptor:${Versions.Retrofit.logging}" }
        val converter by lazy { "com.squareup.retrofit2:converter-gson:${Versions.Retrofit.converter}" }
    }

    object Junit {
        val junit     by lazy { "junit:junit:${Versions.Junit.junit}" }
        val extension by lazy { "androidx.test.ext:junit:${Versions.Junit.extension}" }
    }

    object Mockk {
        val mockk   by lazy { "io.mockk:mockk:${Versions.Mockk.mockk}" }
        val android by lazy { "io.mockk:mockk-android:${Versions.Mockk.mockk}" }
    }

    object Others {
        val desugar by lazy { "com.android.tools:desugar_jdk_libs:${Versions.Others.desugar}" }
        val coil    by lazy { "io.coil-kt:coil-compose:${Versions.Others.coil}" }
        val gson    by lazy { "com.google.code.gson:gson:${Versions.Others.gson}" }
        val json    by lazy { "org.json:json:${Versions.Others.json}" }
    }

    object Versions {
        object Core {
            const val ktx        = "1.7.0"
            const val coroutines = "1.6.2"
        }

        object Compose {
            const val compose    = "1.2.0"
            const val viewmodel  = "2.5.1"
            const val navigation = "2.5.1"
            const val material   = "1.0.0-alpha15"
        }

        object Hilt {
            const val hilt       = "2.42"
            const val navigation = "1.0.0"
        }

        object Retrofit {
            const val retrofit  = "2.9.0"
            const val logging   = "4.9.0"
            const val converter = "2.5.0"
        }

        object Junit {
            const val junit     = "4.13.2"
            const val extension = "1.1.3"
        }


        object Mockk {
            const val mockk = "1.12.5"
        }

        object Others {
            const val desugar = "1.1.5"
            const val gson    = "2.8.7"
            const val coil    = "2.1.0"
            const val json    = "20210307"
        }
    }
}
