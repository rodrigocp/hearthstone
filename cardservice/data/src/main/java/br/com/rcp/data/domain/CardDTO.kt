package br.com.rcp.data.domain

import com.google.gson.annotations.SerializedName

data class CardDTO(
    @SerializedName("cardId") val id: String?,
    @SerializedName("dbfId") val dbf: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("cardSet") val set: String?,
    @SerializedName("type") val type: String?,
    @SerializedName("rarity") val rarity: String?,
    @SerializedName("cost") val cost: Int?,
    @SerializedName("attack") val attack: Int?,
    @SerializedName("health") val health: Int?,
    @SerializedName("text") val text: String?,
    @SerializedName("flavor") val flavor: String?,
    @SerializedName("race") val race: String?,
    @SerializedName("img") val image: String?,
)
