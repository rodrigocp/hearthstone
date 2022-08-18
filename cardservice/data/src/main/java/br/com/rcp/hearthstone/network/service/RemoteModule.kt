package br.com.rcp.hearthstone.network.service

import br.com.rcp.hearthstone.remote.RemoteCardAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RemoteModule {
    @Provides
    fun provideRemoteAPI(serviceFactory: ServiceFactory): RemoteCardAPI {
        return DefaultRemoteServiceFactory(serviceFactory).create()
    }
}
