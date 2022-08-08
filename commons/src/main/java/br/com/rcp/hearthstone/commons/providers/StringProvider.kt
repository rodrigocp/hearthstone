package br.com.rcp.hearthstone.commons.providers

interface StringProvider {
    fun getStringResource(resource: Int) : String
}
