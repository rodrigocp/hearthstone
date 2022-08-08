package br.com.rcp.hearthstone.core.models

sealed class ResponseError(open val message: String) {
    data class Unauthorized(override val message: String) : ResponseError(message)
    data class BadRequest(override val message: String) : ResponseError(message)
    data class NotFound(override val message: String) : ResponseError(message)
    data class AccessDenied(override val message: String) : ResponseError(message)
    data class ServiceUnavailable(override val message: String) : ResponseError(message)
    data class ServiceInternalError(override val message: String) : ResponseError(message)
    data class Unknown(override val message: String) : ResponseError(message)
    data class Network(override val message: String) : ResponseError(message)
}
