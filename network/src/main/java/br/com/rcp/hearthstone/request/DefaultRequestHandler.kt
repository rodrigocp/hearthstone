package br.com.rcp.hearthstone.request

import br.com.rcp.hearthstone.core.models.ResponseWrapper
import br.com.rcp.hearthstone.error.ErrorHandler
import java.lang.Exception
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class DefaultRequestHandler(private val handler: ErrorHandler) : RequestHandler {
    override suspend fun <T> invoke(request: suspend () -> T): ResponseWrapper<T> = withContext(IO) {
        try {
            ResponseWrapper.Success(request.invoke())
        } catch (exception: Exception) {
            ResponseWrapper.Failure(handler.handle(exception))
        }
    }
}
