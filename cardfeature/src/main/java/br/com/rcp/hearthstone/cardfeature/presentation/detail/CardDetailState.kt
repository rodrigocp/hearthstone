package br.com.rcp.hearthstone.cardfeature.presentation.detail

import br.com.rcp.hearthstone.domain.Card

sealed class CardDetailState {
    object Idle : CardDetailState()
    object Loading : CardDetailState()
    data class Success(val information: Card) : CardDetailState()
    data class Failure(val message: String) : CardDetailState()
}
