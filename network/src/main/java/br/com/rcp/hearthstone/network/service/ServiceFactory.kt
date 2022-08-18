package br.com.rcp.hearthstone.network.service

interface ServiceFactory {
    fun <T> create(service: Class<T>): T
}
