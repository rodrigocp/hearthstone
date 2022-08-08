package br.com.rcp.hearthstone.interceptors

import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

class LoggingInterceptorFactory : InterceptorFactory {
    override fun create(): Interceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
}
