package br.com.rcp.hearthstone.repository

import br.com.rcp.hearthstone.core.models.ResponseWrapper
import br.com.rcp.hearthstone.domain.Card
import br.com.rcp.hearthstone.domain.CardDTO
import br.com.rcp.hearthstone.mapper.Mapper
import br.com.rcp.hearthstone.remote.RemoteCardAPI
import br.com.rcp.hearthstone.network.request.RequestHandler
import javax.inject.Inject

class DefaultCardsRepository @Inject constructor(
    private val handler: RequestHandler,
    private val remote: RemoteCardAPI,
    private val mapper: Mapper<CardDTO, Card>
) : CardsRepository {

    override suspend fun getAllCards(): ResponseWrapper<List<Card>> {
        return handler {
            return@handler remote.getAllCards()
                .flatMap { it.value }
                .filter { it.image != null && it.health != null && it.cost != null }
                .map { mapper.map(it) }
        }
    }

    override suspend fun getCardInfo(id: String): ResponseWrapper<List<Card>> {
        return handler {
            return@handler remote.getSingleCard(id)
                .map { mapper.map(it) }
        }
    }

}
