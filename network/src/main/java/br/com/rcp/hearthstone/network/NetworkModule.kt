package br.com.rcp.hearthstone.network

import br.com.rcp.hearthstone.network.api.API
import br.com.rcp.hearthstone.network.api.DefaultAPI
import br.com.rcp.hearthstone.network.cache.CacheFactory
import br.com.rcp.hearthstone.network.cache.DefaultCacheFactory
import br.com.rcp.hearthstone.network.client.DefaultHttpClientFactory
import br.com.rcp.hearthstone.network.client.HttpClientFactory
import br.com.rcp.hearthstone.commons.annotations.CachingInterceptor
import br.com.rcp.hearthstone.commons.annotations.HeadersInterceptor
import br.com.rcp.hearthstone.commons.annotations.LoggingInterceptor
import br.com.rcp.hearthstone.network.error.DefaultErrorHandler
import br.com.rcp.hearthstone.network.error.ErrorHandler
import br.com.rcp.hearthstone.network.interceptors.CachingInterceptorFactory
import br.com.rcp.hearthstone.network.interceptors.HeaderInterceptorFactory
import br.com.rcp.hearthstone.network.interceptors.InterceptorFactory
import br.com.rcp.hearthstone.network.interceptors.LoggingInterceptorFactory
import br.com.rcp.hearthstone.network.request.DefaultRequestHandler
import br.com.rcp.hearthstone.network.request.RequestHandler
import br.com.rcp.hearthstone.network.service.DefaultServiceFactory
import br.com.rcp.hearthstone.network.service.ServiceFactory
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface NetworkModule {
    @Binds
    @LoggingInterceptor
    fun bindLoggingInterceptorFactory(loggingInterceptorFactory: LoggingInterceptorFactory): InterceptorFactory

    @Binds
    @CachingInterceptor
    fun bindCachingInterceptorFactory(cachingInterceptorFactory: CachingInterceptorFactory): InterceptorFactory

    @Binds
    @HeadersInterceptor
    fun bindHeadersInterceptorFactory(headersInterceptorFactory: HeaderInterceptorFactory): InterceptorFactory

    @Binds
    @Singleton
    fun bindErrorHandler(defaultErrorHandler: DefaultErrorHandler): ErrorHandler

    @Binds
    @Singleton
    fun bindRequestHandler(defaultRequestHandler: DefaultRequestHandler): RequestHandler

    @Binds
    fun bindAPI(defaultAPI: DefaultAPI): API

    @Binds
    fun bindCacheFactory(defaultCacheFactory: DefaultCacheFactory): CacheFactory

    @Binds
    fun bindServiceFactory(defaultServiceFactory: DefaultServiceFactory): ServiceFactory

    @Binds
    fun bindHttpClientFactory(defaultHttpClientFactory: DefaultHttpClientFactory): HttpClientFactory
}
