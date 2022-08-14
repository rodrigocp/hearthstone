package br.com.rcp.hearthstone.cardfeature.presentation.list

sealed class CardListIntent {
    object RefreshList : CardListIntent()
}
