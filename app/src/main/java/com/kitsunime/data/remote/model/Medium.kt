package com.kitsunime.data.remote.model


import com.google.gson.annotations.SerializedName

data class Medium(
    @SerializedName("height") val height: Int?,
    @SerializedName("width") val width: Int?,
)