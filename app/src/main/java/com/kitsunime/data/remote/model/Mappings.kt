package com.kitsunime.data.remote.model


import com.google.gson.annotations.SerializedName

data class Mappings(
    @SerializedName("links")
    val links: Links?
)