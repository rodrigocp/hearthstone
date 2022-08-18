package br.com.rcp.hearthstone.network.service

import br.com.rcp.hearthstone.remote.RemoteCardAPI

interface RemoteServiceFactory {
    fun create(): RemoteCardAPI
}
