package br.com.rcp.hearthstone.cache

import okhttp3.Cache

interface CacheFactory {
    fun create(): Cache
}
