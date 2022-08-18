package br.com.rcp.hearthstone.network.interceptors

import javax.inject.Inject
import okhttp3.Interceptor

class CachingInterceptorFactory @Inject constructor() : InterceptorFactory {
    override fun create(): Interceptor = Interceptor { chain ->
        val response = chain.proceed(chain.request())
        val maxAge = 60
        return@Interceptor response.newBuilder()
            .header("Cache-Control", "public, max-age=$maxAge")
            .removeHeader("Pragma")
            .build()
    }
}
