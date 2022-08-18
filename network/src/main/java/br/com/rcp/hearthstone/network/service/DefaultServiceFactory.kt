package br.com.rcp.hearthstone.network.service

import br.com.rcp.hearthstone.network.api.API
import br.com.rcp.hearthstone.network.client.HttpClientFactory
import javax.inject.Inject
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DefaultServiceFactory @Inject constructor(
    private val client: HttpClientFactory,
    private val api: API
) : ServiceFactory {
    override fun <T> create(service: Class<T>): T = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(api.base)
            .client(client.create())
            .build()
            .create(service)
}
