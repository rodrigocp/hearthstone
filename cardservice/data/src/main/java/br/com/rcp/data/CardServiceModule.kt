package br.com.rcp.data

import br.com.rcp.data.domain.CardDTO
import br.com.rcp.data.mapper.CardMapper
import br.com.rcp.data.mapper.Mapper
import br.com.rcp.data.remote.RemoteCardAPI
import br.com.rcp.data.repository.DefaultCardsRepository
import br.com.rcp.hearthstone.api.API
import br.com.rcp.hearthstone.api.DefaultAPI
import br.com.rcp.hearthstone.domain.Card
import br.com.rcp.hearthstone.repository.CardsRepository
import br.com.rcp.hearthstone.service.ServiceFactory
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun injectCardServiceModule() = modules

private val modules by lazy {
    loadKoinModules(
        module {
            factory { get<ServiceFactory>().create(RemoteCardAPI::class.java) }

            factory<API> { DefaultAPI() }
            factory<Mapper<CardDTO, Card>> { CardMapper() }

            single<CardsRepository> { DefaultCardsRepository(get(), get(), get()) }
        }
    )
}
