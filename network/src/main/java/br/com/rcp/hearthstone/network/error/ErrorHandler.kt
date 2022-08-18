package br.com.rcp.hearthstone.network.error

import br.com.rcp.hearthstone.core.models.ResponseError
import java.lang.Exception

interface ErrorHandler {
    fun handle(exception: Exception): ResponseError
}
