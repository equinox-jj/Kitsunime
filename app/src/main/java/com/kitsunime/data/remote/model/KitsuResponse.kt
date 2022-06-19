package com.kitsunime.data.remote.model


import com.google.gson.annotations.SerializedName

data class KitsuResponse(
    @SerializedName("data") val data: List<KitsuResults>,
    @SerializedName("kitsuIncluded") val kitsuIncluded: List<KitsuIncluded>?,
    @SerializedName("links") val links: Links?,
)