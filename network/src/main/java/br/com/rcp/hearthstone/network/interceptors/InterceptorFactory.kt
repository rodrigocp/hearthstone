package br.com.rcp.hearthstone.network.interceptors

import okhttp3.Interceptor

interface InterceptorFactory {
    fun create(): Interceptor
}
