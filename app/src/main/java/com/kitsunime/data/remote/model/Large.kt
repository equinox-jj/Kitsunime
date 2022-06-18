package com.kitsunime.data.remote.model


import com.google.gson.annotations.SerializedName
import com.kitsunime.domain.model.KitsuLarge

data class Large(
    @SerializedName("height") val height: Int?,
    @SerializedName("width") val width: Int?,
)

fun Large.toKitsuLarge(): KitsuLarge {
    return KitsuLarge(
        height = height,
        width = width
    )
}