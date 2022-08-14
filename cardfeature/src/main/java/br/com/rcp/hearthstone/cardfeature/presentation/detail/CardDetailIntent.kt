package br.com.rcp.hearthstone.cardfeature.presentation.detail

sealed class CardDetailIntent {
    data class RefreshDetail(val id: String) : CardDetailIntent()
}
