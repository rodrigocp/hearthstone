package br.com.rcp.hearthstone.network.cache

import android.content.Context
import br.com.rcp.hearthstone.network.BuildConfig
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import okhttp3.Cache

class DefaultCacheFactory @Inject constructor(@ApplicationContext private val context: Context) :
    CacheFactory {
    override fun create(): Cache = Cache(context.cacheDir, BuildConfig.CACHE_SIZE)
}
