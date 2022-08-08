package br.com.rcp.hearthstone.api

import br.com.rcp.hearthstone.BuildConfig

class DefaultAPI : API {
    override val base : String = BuildConfig.BASE_URL
}
