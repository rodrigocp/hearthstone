package br.com.rcp.hearthstone.mapper

import br.com.rcp.hearthstone.domain.CardDTO
import br.com.rcp.hearthstone.domain.Card
import javax.inject.Inject

class CardMapper @Inject constructor() : Mapper<CardDTO, Card> {
    override fun map(type: CardDTO): Card = Card(
        id = type.id ?: "",
        dbf = type.dbf ?: "",
        name = type.name ?: "",
        set = type.set ?: "",
        type = type.type ?: "",
        rarity = type.rarity ?: "",
        cost = type.cost ?: 0,
        attack = type.attack ?: 0,
        health = type.health ?: 0,
        text = type.text ?: "",
        flavor = type.flavor ?: "",
        race = type.race ?: "",
        image = type.image ?: ""
    )
}
