package br.com.rcp.hearthstone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.rcp.hearthstone.cardfeature.presentation.detail.CardDetailView
import br.com.rcp.hearthstone.cardfeature.presentation.list.CardListView
import br.com.rcp.hearthstone.repository.CardsRepository
import br.com.rcp.hearthstone.ui.theme.HearthstoneTheme
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {
    val test : CardsRepository by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HearthstoneTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainNavigationHost()
                }
            }
        }
    }
}

@Composable
fun MainNavigationHost(
    modifier: Modifier = Modifier,
    controller: NavHostController = rememberNavController(),
    start: String = "cardListView"
) {
    NavHost(
        modifier = modifier, navController = controller, startDestination = start
    ) {
        composable("cardListView") {
            CardListView(controller)
        }

        composable("cardDetail/{id}") {
            CardDetailView(it.arguments?.getString("id") ?: "")
        }
    }
}
