package br.com.rcp.hearthstone

import br.com.rcp.hearthstone.api.API
import br.com.rcp.hearthstone.api.DefaultAPI
import br.com.rcp.hearthstone.cache.CacheFactory
import br.com.rcp.hearthstone.cache.DefaultCache
import br.com.rcp.hearthstone.client.DefaultHttpClient
import br.com.rcp.hearthstone.client.HttpClientFactory
import br.com.rcp.hearthstone.error.DefaultErrorHandler
import br.com.rcp.hearthstone.error.ErrorHandler
import br.com.rcp.hearthstone.interceptors.CachingInterceptorFactory
import br.com.rcp.hearthstone.interceptors.HeaderInterceptorFactory
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

private val logging = named("loggingInterceptorFactory")
private val caching = named("cachingInterceptorFactory")
private val headers = named("headerInterceptorFactory")

fun injectNetworkModule() = modules

private val modules by lazy {
    loadKoinModules(
        module {
            single<HttpClientFactory> {
                DefaultHttpClient(
                    get(),
                    get(logging),
                    get(caching),
                    get(headers)
                )
            }

            factory<API> { DefaultAPI() }
            factory<ErrorHandler> { DefaultErrorHandler(get()) }
            factory<RequestHandler> { DefaultRequestHandler(get()) }

            factory<CacheFactory> { DefaultCache(androidContext()) }
            factory<InterceptorFactory>(logging) { LoggingInterceptorFactory() }
            factory<InterceptorFactory>(caching) { CachingInterceptorFactory() }
            factory<InterceptorFactory>(headers) { HeaderInterceptorFactory() }

            single<ServiceFactory> { DefaultService(get(), get()) }
        }
    )
}
