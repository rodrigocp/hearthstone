package br.com.rcp.hearthstone.commons.providers

import android.content.Context

class DefaultStringProvider(private val context: Context) : StringProvider {
    override fun getStringResource(resource: Int): String = context.getString(resource)
}
