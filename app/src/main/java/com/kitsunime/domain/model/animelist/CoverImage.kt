package com.kitsunime.domain.model.animelist


import com.google.gson.annotations.SerializedName

data class CoverImage(
    @SerializedName("large")
    val large: String?,
    @SerializedName("meta")
    val meta: Meta?,
    @SerializedName("original")
    val original: String?,
    @SerializedName("small")
    val small: String?,
    @SerializedName("tiny")
    val tiny: String?
)