package br.com.rcp.hearthstone.network.interceptors

import javax.inject.Inject
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

class LoggingInterceptorFactory @Inject constructor() : InterceptorFactory {
    override fun create(): Interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
}
