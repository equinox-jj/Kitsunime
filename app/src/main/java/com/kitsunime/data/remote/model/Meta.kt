package com.kitsunime.data.remote.model


import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("dimensions")
    val dimensions: Dimensions?,
    @SerializedName("count")
    val count: Int?
)