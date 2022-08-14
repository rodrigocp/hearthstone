package br.com.rcp.hearthstone.domain

data class Card(
    val id: String,
    val dbf: String,
    val name: String,
    val set: String,
    val type: String,
    val rarity: String,
    val cost: Int,
    val attack: Int,
    val health: Int,
    val text: String,
    val flavor: String,
    val race: String,
    val image: String,
)
