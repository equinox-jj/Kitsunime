package com.kitsunime.data.remote.model


import com.google.gson.annotations.SerializedName
import com.kitsunime.domain.model.KitsuTiny

data class Tiny(
    @SerializedName("height") val height: Int?,
    @SerializedName("width") val width: Int?,
)

fun Tiny.toKitsuTiny(): KitsuTiny {
    return KitsuTiny(
        height = height,
        width = width
    )
}