package br.com.rcp.hearthstone.network.request

import br.com.rcp.hearthstone.core.models.ResponseWrapper
import br.com.rcp.hearthstone.network.error.ErrorHandler
import java.lang.Exception
import javax.inject.Inject
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.withContext

class DefaultRequestHandler @Inject constructor(private val handler: ErrorHandler) :
    RequestHandler {
    override suspend fun <T> invoke(request: suspend () -> T): ResponseWrapper<T> = withContext(IO) {
        try {
            ResponseWrapper.Success(request.invoke())
        } catch (exception: Exception) {
            ResponseWrapper.Failure(handler.handle(exception))
        }
    }
}
