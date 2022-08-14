package br.com.rcp.hearthstone.cardfeature.presentation.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.rcp.hearthstone.domain.Card
import coil.compose.rememberAsyncImagePainter
import org.koin.androidx.compose.getViewModel

@Composable
fun CardDetailView(id: String) {
    val cardViewModel: CardDetailViewModel = getViewModel()
    val state by cardViewModel.state.collectAsState()

    when (state) {
        is CardDetailState.Idle -> { cardViewModel.send(CardDetailIntent.RefreshDetail(id)) }
        is CardDetailState.Loading -> LoadingDetails()
        is CardDetailState.Success -> CardDetails((state as CardDetailState.Success).information)
        is CardDetailState.Failure -> { }
    }
}

@Composable
fun LoadingDetails() {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun CardDetails(detail: Card) {
    Column {
        Text(text = "Nome: ${detail.name}")
        Text(text = "Descrição: ${detail.flavor}")
        Text(text = "Descrição Curta: ${detail.text}")
        Text(text = "Set: ${detail.set}")
        Text(text = "Tipo: ${detail.type}")
        Text(text = "Facção: ${detail.race}")
        Text(text = "Raridade: ${detail.rarity}")
        Text(text = "Ataque: ${detail.attack}")
        Text(text = "Custo: ${detail.cost}")
        Text(text = "Saúde: ${detail.health}")
        Image(
            modifier = Modifier.padding(8.dp).size(512.dp).align(alignment = Alignment.CenterHorizontally),
            painter = rememberAsyncImagePainter(detail.image),
            contentDescription = detail.flavor
        )
    }
}
