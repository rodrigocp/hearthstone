package br.com.rcp.hearthstone

import br.com.rcp.hearthstone.cache.CacheFactory
import br.com.rcp.hearthstone.cache.DefaultCache
import br.com.rcp.hearthstone.client.DefaultHttpClient
import br.com.rcp.hearthstone.client.HttpClientFactory
import br.com.rcp.hearthstone.error.DefaultErrorHandler
import br.com.rcp.hearthstone.error.ErrorHandler
import br.com.rcp.hearthstone.interceptors.CachingInterceptorFactory
import br.com.rcp.hearthstone.interceptors.InterceptorFactory
import br.com.rcp.hearthstone.interceptors.LoggingInterceptorFactory
import br.com.rcp.hearthstone.request.DefaultRequestHandler
import br.com.rcp.hearthstone.request.RequestHandler
import br.com.rcp.hearthstone.service.DefaultService
import br.com.rcp.hearthstone.service.ServiceFactory
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun injectNetworkModule() = modules

private val modules by lazy {
    loadKoinModules(
        module {
            factory<RequestHandler> { DefaultRequestHandler(get()) }
            factory<HttpClientFactory> { DefaultHttpClient(get(), get(named("loggingInterceptorFactory")), get(named("cachingInterceptorFactory"))) }
            factory<InterceptorFactory>(named("loggingInterceptorFactory")) { LoggingInterceptorFactory() }
            factory<InterceptorFactory>(named("cachingInterceptorFactory")) { CachingInterceptorFactory() }
            single<CacheFactory> { DefaultCache(androidContext()) }
            single<ServiceFactory> { DefaultService(get(), get()) }
            single<ErrorHandler> { DefaultErrorHandler(get()) }
        }
    )
}
