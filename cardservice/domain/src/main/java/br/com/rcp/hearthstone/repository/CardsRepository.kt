package br.com.rcp.hearthstone.repository

import br.com.rcp.hearthstone.core.models.ResponseWrapper
import br.com.rcp.hearthstone.domain.Card

interface CardsRepository {
    suspend fun getAllCards(): ResponseWrapper<List<Card>>
    suspend fun getCardInfo(id: String): ResponseWrapper<List<Card>>
}
