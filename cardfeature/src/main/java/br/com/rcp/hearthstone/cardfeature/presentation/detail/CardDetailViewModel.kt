package br.com.rcp.hearthstone.cardfeature.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.rcp.hearthstone.core.models.onFailure
import br.com.rcp.hearthstone.core.models.onSuccess
import br.com.rcp.hearthstone.repository.CardsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

@HiltViewModel
class CardDetailViewModel @Inject constructor(private val repository: CardsRepository) : ViewModel() {
    val state: MutableStateFlow<CardDetailState> get() = _state
    private val _state: MutableStateFlow<CardDetailState> = MutableStateFlow(CardDetailState.Idle)

    fun send(intent: CardDetailIntent) {
        when(intent) {
            is CardDetailIntent.RefreshDetail -> fetchCardDetail(intent.id)
        }
    }

    private fun fetchCardDetail(id: String) {
        if (_state.value !is CardDetailState.Idle) {
            return
        }

        setState(CardDetailState.Loading)

        viewModelScope.launch {
            repository.getCardInfo(id)
                .onSuccess {
                    setState(CardDetailState.Success(it.first()))
                }
                .onFailure {
                    setState(CardDetailState.Failure(it.message))
                }
        }
    }

    private fun setState(state: CardDetailState) {
        _state.value = state
    }
}
