package com.carol.musyoka.superhero.data.model

import com.google.gson.annotations.SerializedName

data class Work(
    @SerializedName("occupation")
    val occupation: String,

    @SerializedName("base")
    val base: String
)