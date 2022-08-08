package br.com.rcp.hearthstone.request

import br.com.rcp.hearthstone.core.models.ResponseWrapper

interface RequestHandler {
    suspend operator fun <T> invoke(request: suspend() -> (T)): ResponseWrapper<T>
}
