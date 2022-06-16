package com.kitsunime.data.remote.model


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