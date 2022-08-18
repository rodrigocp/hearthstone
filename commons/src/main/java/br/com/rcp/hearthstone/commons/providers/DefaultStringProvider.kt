package br.com.rcp.hearthstone.commons.providers

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class DefaultStringProvider @Inject constructor(@ApplicationContext private val context: Context) : StringProvider {
    override fun getStringResource(resource: Int): String = context.getString(resource)
}
