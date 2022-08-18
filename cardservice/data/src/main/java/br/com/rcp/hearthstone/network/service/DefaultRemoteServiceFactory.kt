package br.com.rcp.hearthstone.network.service

import br.com.rcp.hearthstone.remote.RemoteCardAPI
import javax.inject.Inject

class DefaultRemoteServiceFactory @Inject constructor(private val service: ServiceFactory) : RemoteServiceFactory {
    override fun create(): RemoteCardAPI {
        return service.create(RemoteCardAPI::class.java)
    }
}
