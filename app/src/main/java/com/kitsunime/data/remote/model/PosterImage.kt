package com.kitsunime.data.remote.model


import com.google.gson.annotations.SerializedName
import com.kitsunime.domain.model.KitsuPosterImage

data class PosterImage(
    @SerializedName("large") val large: String?,
    @SerializedName("medium") val medium: String?,
    @SerializedName("original") val original: String?,
    @SerializedName("small") val small: String?,
    @SerializedName("tiny") val tiny: String?,
)

fun PosterImage.toKitsuPosterImage(): KitsuPosterImage {
    return KitsuPosterImage(
        large = large,
        medium = medium,
        original = original,
        small = small,
        tiny = tiny
    )
}