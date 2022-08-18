package br.com.rcp.hearthstone.network.client

import okhttp3.OkHttpClient

interface HttpClientFactory {
    fun create(): OkHttpClient
}
