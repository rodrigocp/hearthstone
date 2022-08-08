package br.com.rcp.hearthstone.error

import br.com.rcp.hearthstone.R
import br.com.rcp.hearthstone.commons.providers.StringProvider
import br.com.rcp.hearthstone.core.models.ResponseError
import java.io.IOException
import java.lang.Exception
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException

private const val ERROR = "error"
private const val MESSAGE = "message"

class DefaultErrorHandler(private val provider: StringProvider) : ErrorHandler {
    override fun handle(exception: Exception): ResponseError = when (exception) {
        is IOException -> ResponseError.Network(provider.getStringResource(R.string.network_error))
        is HttpException -> handleHttpException(exception)
        else -> ResponseError.Unknown(exception.message ?: provider.getStringResource(R.string.unknown_error))
    }

    private fun handleHttpException(exception: HttpException) : ResponseError {
        return when (exception.code()) {
            400 -> ResponseError.BadRequest(getErrorMessage(exception))
            401 -> ResponseError.Unauthorized(getErrorMessage(exception))
            403 -> ResponseError.AccessDenied(getErrorMessage(exception))
            404 -> ResponseError.NotFound(getErrorMessage(exception))
            500 -> ResponseError.ServiceInternalError(getErrorMessage(exception))
            503 -> ResponseError.ServiceUnavailable(getErrorMessage(exception))
            else -> ResponseError.Unknown(getErrorMessage(exception))
        }
    }

    private fun getErrorMessage(exception: HttpException) : String {
        return with(exception) {
            getErrorFromResponseBody(this).ifBlank {
                getMessageFromResponseBody(exception)
            }
        }
    }

    private fun getErrorFromResponseBody(exception: HttpException) : String {
        return getMessageErrorFromBody(exception, ERROR)
    }

    private fun getMessageFromResponseBody(exception: HttpException) : String {
        return getMessageErrorFromBody(exception, MESSAGE)
    }

    private fun getMessageErrorFromBody(exception: HttpException, parameter: String) : String {
        return try {
            exception.response()?.errorBody()?.string()?.let {
                JSONObject(it).getString(parameter)
            } ?: ""
        } catch (exception: JSONException) {
            exception.message.toString()
        }
    }
}
