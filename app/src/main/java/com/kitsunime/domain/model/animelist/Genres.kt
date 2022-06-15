package com.kitsunime.domain.model.animelist


import com.google.gson.annotations.SerializedName

data class Genres(
    @SerializedName("links")
    val links: Links?
)