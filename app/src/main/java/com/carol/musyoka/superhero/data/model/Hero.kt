package com.carol.musyoka.superhero.data.model

import com.google.gson.annotations.SerializedName

data class Hero(
    @SerializedName("id")
    val id: Long,

    @SerializedName("name")
    val name: String,

    @SerializedName("slug")
    val slug: String,

    @SerializedName("powerstats")
    val powerStat: PowerStat,

    @SerializedName("appearance")
    val appearance: Appearance,

    @SerializedName("biography")
    val biography: Biography,

    @SerializedName("work")
    val work: Work,

    @SerializedName("connections")
    val connection: Connection,

    @SerializedName("images")
    val image: Image
)