package br.com.rcp.hearthstone.interceptors

import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

class CachingInterceptorFactory : InterceptorFactory {
    override fun create(): Interceptor = Interceptor { chain ->
        val response = chain.proceed(chain.request())
        val maxAge = 60
        return@Interceptor response.newBuilder()
            .header("Cache-Control", "public, max-age=$maxAge")
            .removeHeader("Pragma")
            .build()
    }
}
