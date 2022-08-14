package br.com.rcp.hearthstone.cardfeature.presentation.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.rcp.hearthstone.domain.Card
import coil.compose.rememberAsyncImagePainter
import org.koin.androidx.compose.getViewModel

@Composable
fun CardListView(controller: NavController) {
    val cardViewModel: CardListViewModel = getViewModel()
    val state by cardViewModel.state.collectAsState()

    when (state) {
        is CardListState.Idle -> { cardViewModel.send(CardListIntent.RefreshList) }
        is CardListState.Loading -> LoadingCards()
        is CardListState.Success -> CardsBack((state as CardListState.Success).collection, controller)
        is CardListState.Failure -> { }
    }
}

@Composable
fun LoadingCards() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun CardsBack(data: List<Card>, controller: NavController) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        state = rememberLazyGridState(),
    ) {
        items(data) { card ->
            Image(
                modifier = Modifier.padding(8.dp).size(128.dp).clickable {
                    controller.navigate("cardDetail/${card.id}")
                },
                painter = rememberAsyncImagePainter(card.image),
                contentDescription = "Card`s Back"
            )
        }
    }
}
