package com.kitsunime.data.remote.model


import com.google.gson.annotations.SerializedName
import com.kitsunime.domain.model.KitsuCoverImage

data class CoverImage(
    @SerializedName("large") val large: String?,
    @SerializedName("original") val original: String?,
    @SerializedName("small") val small: String?,
    @SerializedName("tiny") val tiny: String?,
)

fun CoverImage.toKitsuCoverImage(): KitsuCoverImage {
    return KitsuCoverImage(
        large = large,
        original = original,
        small = small,
        tiny = tiny
    )
}