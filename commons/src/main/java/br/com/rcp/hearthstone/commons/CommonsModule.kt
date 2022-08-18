package br.com.rcp.hearthstone.commons

import br.com.rcp.hearthstone.commons.providers.DefaultStringProvider
import br.com.rcp.hearthstone.commons.providers.StringProvider
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class CommonsModule {
    @Binds
    @Singleton
    abstract fun bindStringProvider(defaultStringProvider: DefaultStringProvider) : StringProvider
}
