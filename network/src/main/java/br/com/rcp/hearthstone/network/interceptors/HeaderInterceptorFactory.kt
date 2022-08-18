package br.com.rcp.hearthstone.network.interceptors

import br.com.rcp.hearthstone.network.BuildConfig
import javax.inject.Inject
import okhttp3.Interceptor

class HeaderInterceptorFactory @Inject constructor() : InterceptorFactory {
    override fun create(): Interceptor = Interceptor { chain ->
        val request = chain.request()
            .newBuilder()
            .header(BuildConfig.API_HOST_NAME, BuildConfig.API_HOST_VALUE)
            .header(BuildConfig.API_KEY_NAME, BuildConfig.API_KEY_VALUE)
            .build()
        return@Interceptor chain.proceed(request)
    }
}
