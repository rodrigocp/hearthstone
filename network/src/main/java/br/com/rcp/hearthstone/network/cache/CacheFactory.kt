package br.com.rcp.hearthstone.network.cache

import okhttp3.Cache

interface CacheFactory {
    fun create(): Cache
}
