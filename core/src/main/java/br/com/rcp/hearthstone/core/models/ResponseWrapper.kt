package br.com.rcp.hearthstone.core.models

sealed class ResponseWrapper<out T> {
    data class Success<T>(val response: T) : ResponseWrapper<T>()
    data class Failure<T>(val detailed: ResponseError) : ResponseWrapper<T>()
}

fun <T> ResponseWrapper<T>.onFailure(invokable: (ResponseError) -> Unit): ResponseWrapper<T> {
    if (this is ResponseWrapper.Failure) invokable.invoke(this.detailed)
    return this
}

fun <T> ResponseWrapper<T>.onSuccess(invokable: (T) -> Unit): ResponseWrapper<T> {
    if (this is ResponseWrapper.Success) invokable.invoke(this.response)
    return this
}
