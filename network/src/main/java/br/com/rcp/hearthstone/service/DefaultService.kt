package br.com.rcp.hearthstone.service

import br.com.rcp.hearthstone.api.API
import br.com.rcp.hearthstone.client.HttpClientFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class DefaultService(
    private val client: HttpClientFactory,
    private val api: API
) : ServiceFactory {
    override fun <T> create(service: Class<T>): T = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create())
            .baseUrl(api.base)
            .client(client.create())
            .build()
            .create(service)
}
