package br.com.rcp.hearthstone.network.request

import br.com.rcp.hearthstone.core.models.ResponseWrapper

interface RequestHandler {
    suspend operator fun <T> invoke(request: suspend() -> (T)): ResponseWrapper<T>
}
