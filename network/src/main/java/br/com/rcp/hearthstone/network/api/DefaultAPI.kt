package br.com.rcp.hearthstone.network.api

import br.com.rcp.hearthstone.network.BuildConfig
import javax.inject.Inject

class DefaultAPI @Inject constructor() : API {
    override val base : String = BuildConfig.BASE_URL
}
