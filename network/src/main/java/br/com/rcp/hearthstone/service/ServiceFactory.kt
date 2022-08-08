package br.com.rcp.hearthstone.service

interface ServiceFactory {
    fun <T> create(service: Class<T>): T
}
