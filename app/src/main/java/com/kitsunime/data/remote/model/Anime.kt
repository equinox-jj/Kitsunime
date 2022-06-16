package com.kitsunime.data.remote.model


import com.google.gson.annotations.SerializedName

data class Anime(
    @SerializedName("links")
    val links: Links?
)