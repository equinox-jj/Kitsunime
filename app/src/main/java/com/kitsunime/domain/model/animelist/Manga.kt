package com.kitsunime.domain.model.animelist


import com.google.gson.annotations.SerializedName

data class Manga(
    @SerializedName("links")
    val links: Links?
)