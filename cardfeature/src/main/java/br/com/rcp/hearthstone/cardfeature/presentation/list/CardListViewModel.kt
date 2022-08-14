package br.com.rcp.hearthstone.cardfeature.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.rcp.hearthstone.core.models.onFailure
import br.com.rcp.hearthstone.core.models.onSuccess
import br.com.rcp.hearthstone.repository.CardsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CardListViewModel(private val repository: CardsRepository) : ViewModel() {
    val state: MutableStateFlow<CardListState> get() = _state
    private val _state: MutableStateFlow<CardListState> = MutableStateFlow(CardListState.Idle)

    fun send(intent: CardListIntent) {
        when(intent) {
            is CardListIntent.RefreshList -> fetchCardList()
        }
    }

    private fun fetchCardList() {
        if (_state.value !is CardListState.Idle) {
            return
        }

        setState(CardListState.Loading)

        viewModelScope.launch {
            repository.getAllCards()
                .onSuccess {
                    setState(CardListState.Success(it))
                }
                .onFailure {
                    setState(CardListState.Failure(it.message))
                }
        }
    }

    private fun setState(state: CardListState) {
        _state.value = state
    }
}
