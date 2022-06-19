package com.kitsunime.data.remote.model


import com.google.gson.annotations.SerializedName

data class PosterImage(
    @SerializedName("large") val large: String?,
    @SerializedName("medium") val medium: String?,
    @SerializedName("original") val original: String?,
    @SerializedName("small") val small: String?,
    @SerializedName("tiny") val tiny: String?,
)