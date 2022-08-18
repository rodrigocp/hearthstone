package br.com.rcp.hearthstone.remote

import br.com.rcp.hearthstone.domain.CardDTO
import retrofit2.http.GET
import retrofit2.http.Path

interface RemoteCardAPI {
    @GET("cards")
    suspend fun getAllCards(): Map<String, List<CardDTO>>

    @GET("cards/{id}")
    suspend fun getSingleCard(@Path("id") id: String): List<CardDTO>
}
