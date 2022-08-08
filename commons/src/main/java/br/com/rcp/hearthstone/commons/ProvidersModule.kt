package br.com.rcp.hearthstone.commons

import br.com.rcp.hearthstone.commons.providers.DefaultStringProvider
import br.com.rcp.hearthstone.commons.providers.StringProvider
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

fun injectProvidersModule() = modules

private val modules by lazy {
    loadKoinModules(
        module {
            single<StringProvider> { DefaultStringProvider(androidContext()) }
        }
    )
}
