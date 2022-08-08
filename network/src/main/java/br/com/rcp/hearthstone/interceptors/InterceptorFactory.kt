package br.com.rcp.hearthstone.interceptors

import okhttp3.Interceptor

interface InterceptorFactory {
    fun create(): Interceptor
}
