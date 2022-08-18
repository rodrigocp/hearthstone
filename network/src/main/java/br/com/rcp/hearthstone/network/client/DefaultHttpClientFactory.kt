package br.com.rcp.hearthstone.network.client

import br.com.rcp.hearthstone.network.cache.CacheFactory
import br.com.rcp.hearthstone.commons.annotations.CachingInterceptor
import br.com.rcp.hearthstone.commons.annotations.HeadersInterceptor
import br.com.rcp.hearthstone.commons.annotations.LoggingInterceptor
import br.com.rcp.hearthstone.network.interceptors.InterceptorFactory
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import okhttp3.OkHttpClient

class DefaultHttpClientFactory @Inject constructor(
    private val cache: CacheFactory,
    @LoggingInterceptor private val loggingInterceptor: InterceptorFactory,
    @CachingInterceptor private val cachingInterceptor: InterceptorFactory,
    @HeadersInterceptor private val headersInterceptor: InterceptorFactory
) : HttpClientFactory {
    override fun create(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .addInterceptor(loggingInterceptor.create())
        .addInterceptor(headersInterceptor.create())
        .addNetworkInterceptor(cachingInterceptor.create())
        .cache(cache.create())
        .build()
}
