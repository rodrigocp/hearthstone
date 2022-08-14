package br.com.rcp.data.remote

import br.com.rcp.data.domain.CardDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteCardAPI {
    @GET("cards")
    suspend fun getAllCards(): Map<String, List<CardDTO>>

    @GET("cards/{id}")
    suspend fun getSingleCard(@Path("id") id: String): List<CardDTO>
}
