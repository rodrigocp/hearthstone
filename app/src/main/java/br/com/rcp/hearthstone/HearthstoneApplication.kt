package br.com.rcp.hearthstone

import android.app.Application
import br.com.rcp.data.injectCardServiceModule
import br.com.rcp.hearthstone.cardfeature.injectCardFeature
import br.com.rcp.hearthstone.commons.injectCommonsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class HearthstoneApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin { androidContext(this@HearthstoneApplication) }
        injectCommonsModule()
        injectNetworkModule()
        injectCardServiceModule()
        injectCardFeature()
    }
}
