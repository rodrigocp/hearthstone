package br.com.rcp.data.repository

import br.com.rcp.data.domain.CardDTO
import br.com.rcp.data.mapper.Mapper
import br.com.rcp.data.remote.RemoteCardAPI
import br.com.rcp.hearthstone.core.models.ResponseWrapper
import br.com.rcp.hearthstone.domain.Card
import br.com.rcp.hearthstone.repository.CardsRepository
import br.com.rcp.hearthstone.request.RequestHandler

class DefaultCardsRepository(
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
