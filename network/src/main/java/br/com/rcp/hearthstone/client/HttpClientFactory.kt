package br.com.rcp.hearthstone.client

import okhttp3.OkHttpClient

interface HttpClientFactory {
    fun create(): OkHttpClient
}
