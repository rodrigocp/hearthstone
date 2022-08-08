package br.com.rcp.hearthstone.error

import br.com.rcp.hearthstone.core.models.ResponseError
import java.lang.Exception

interface ErrorHandler {
    fun handle(exception: Exception): ResponseError
}
