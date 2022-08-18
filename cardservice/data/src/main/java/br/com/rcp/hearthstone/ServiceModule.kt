package br.com.rcp.hearthstone

import br.com.rcp.hearthstone.domain.Card
import br.com.rcp.hearthstone.domain.CardDTO
import br.com.rcp.hearthstone.mapper.CardMapper
import br.com.rcp.hearthstone.mapper.Mapper
import br.com.rcp.hearthstone.repository.CardsRepository
import br.com.rcp.hearthstone.repository.DefaultCardsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ServiceModule {
    @Binds
    @Singleton
    fun bindCardRepository(defaultCardsRepository: DefaultCardsRepository): CardsRepository

    @Binds
    @Singleton
    fun bindMapper(cardMapper: CardMapper): Mapper<CardDTO, Card>
}
