package com.unoth.cryptoapp.domain

data class CoinInfo(
    val fromsymbol: String,
    val tosymbol: String?,
    val lastmarket: String?,
    val price: Double?,
    val lastupdate: Long?,
    val highday: Double?,
    val lowday: Double?,
    val imageurl: String?
)