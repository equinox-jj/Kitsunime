package com.kitsunime.data.remote.model


import com.google.gson.annotations.SerializedName

data class CoverImage(
    @SerializedName("large") val large: String?,
    @SerializedName("original") val original: String?,
    @SerializedName("small") val small: String?,
    @SerializedName("tiny") val tiny: String?,
)