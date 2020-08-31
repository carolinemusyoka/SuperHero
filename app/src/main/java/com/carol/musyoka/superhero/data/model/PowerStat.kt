package com.carol.musyoka.superhero.data.model

import com.google.gson.annotations.SerializedName

data class PowerStat(
    @SerializedName("intelligence")
    val intelligence: Int,

    @SerializedName("strength")
    val strength: Int,

    @SerializedName("speed")
    val speed: Int,

    @SerializedName("durability")
    val durability: Int,

    @SerializedName("power")
    val power: Int,

    @SerializedName("combat")
    val combat: Int
)