package com.carol.musyoka.superhero.data.model

import com.google.gson.annotations.SerializedName

data class Connection(
    @SerializedName("groupAffiliation")
    val groupAffiliation: String,

    @SerializedName("relatives")
    val relatives: String
)