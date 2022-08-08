package br.com.rcp.hearthstone.client

import br.com.rcp.hearthstone.cache.CacheFactory
import br.com.rcp.hearthstone.interceptors.InterceptorFactory
import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient

class DefaultHttpClient(
    private val cache: CacheFactory,
    private val loggingInterceptor: InterceptorFactory,
    private val cachingInterceptor: InterceptorFactory
) : HttpClientFactory {
    override fun create(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor.create())
        .addNetworkInterceptor(cachingInterceptor.create())
        .cache(cache.create())
        .build()
}
