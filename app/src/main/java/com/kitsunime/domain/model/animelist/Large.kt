package com.kitsunime.domain.model.animelist


import com.google.gson.annotations.SerializedName

data class Large(
    @SerializedName("height")
    val height: Int?,
    @SerializedName("width")
    val width: Int?
)