package com.kitsunime.data.remote.model


import com.google.gson.annotations.SerializedName
import com.kitsunime.domain.model.KitsuSmall

data class Small(
    @SerializedName("height") val height: Int?,
    @SerializedName("width") val width: Int?,
)

fun Small.toKitsuSmall(): KitsuSmall {
    return KitsuSmall(
        height = height,
        width = width
    )
}