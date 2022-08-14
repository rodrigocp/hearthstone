package br.com.rcp.hearthstone.cardfeature

import br.com.rcp.hearthstone.cardfeature.presentation.detail.CardDetailViewModel
import br.com.rcp.hearthstone.cardfeature.presentation.list.CardListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun injectCardFeature() = modules

private val modules by lazy {
    loadKoinModules(
        module {
            viewModel { CardListViewModel(get()) }
            viewModel { CardDetailViewModel(get()) }
        }
    )
}
