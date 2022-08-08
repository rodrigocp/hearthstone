package br.com.rcp.hearthstone.cache

import android.content.Context
import br.com.rcp.hearthstone.BuildConfig
import okhttp3.Cache

class DefaultCache(private val context: Context) : CacheFactory {
    override fun create(): Cache = Cache(context.cacheDir, BuildConfig.CACHE_SIZE)
}
