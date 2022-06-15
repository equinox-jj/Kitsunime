package com.kitsunime.domain.model.animelist


import com.google.gson.annotations.SerializedName

data class Categories(
    @SerializedName("data")
    val `data`: List<Data>?,
    @SerializedName("links")
    val links: Links?
)