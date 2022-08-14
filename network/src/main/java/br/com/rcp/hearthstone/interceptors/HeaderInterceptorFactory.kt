package br.com.rcp.hearthstone.interceptors

import br.com.rcp.hearthstone.BuildConfig
import okhttp3.Interceptor

class HeaderInterceptorFactory : InterceptorFactory {
    override fun create(): Interceptor = Interceptor { chain ->
        val request = chain.request()
            .newBuilder()
            .header(BuildConfig.API_HOST_NAME, BuildConfig.API_HOST_VALUE)
            .header(BuildConfig.API_KEY_NAME, BuildConfig.API_KEY_VALUE)
            .build()
        return@Interceptor chain.proceed(request)
    }
}
