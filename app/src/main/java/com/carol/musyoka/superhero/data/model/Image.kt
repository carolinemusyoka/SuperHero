package com.carol.musyoka.superhero.data.model

import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("xs")
    val xs: String,

    @SerializedName("sm")
    val sm: String,

    @SerializedName("md")
    val md: String,

    @SerializedName("lg")
    val lg: String
)