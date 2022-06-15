package com.kitsunime.domain.model.animelist


import com.google.gson.annotations.SerializedName

data class Dimensions(
    @SerializedName("large")
    val large: Large?,
    @SerializedName("medium")
    val medium: Medium?,
    @SerializedName("small")
    val small: Small?,
    @SerializedName("tiny")
    val tiny: Tiny?
)