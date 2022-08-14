package br.com.rcp.hearthstone.cardfeature.presentation.list

import br.com.rcp.hearthstone.domain.Card

sealed class CardListState {
    object Idle : CardListState()
    object Loading : CardListState()
    data class Success(val collection: List<Card>) : CardListState()
    data class Failure(val message: String) : CardListState()
}
