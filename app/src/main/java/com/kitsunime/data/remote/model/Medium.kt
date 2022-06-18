package com.kitsunime.data.remote.model


import com.google.gson.annotations.SerializedName
import com.kitsunime.domain.model.KitsuMedium

data class Medium(
    @SerializedName("height") val height: Int?,
    @SerializedName("width") val width: Int?,
)

fun Medium.toKitsuMedium(): KitsuMedium {
    return KitsuMedium(
        height = height,
        width = width
    )
}