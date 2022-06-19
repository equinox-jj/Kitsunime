package com.kitsunime.data.remote.model


import com.google.gson.annotations.SerializedName

data class Categories(
    @SerializedName("data") val data: List<KitsuResults>?,
    @SerializedName("links") val links: Links?,
)