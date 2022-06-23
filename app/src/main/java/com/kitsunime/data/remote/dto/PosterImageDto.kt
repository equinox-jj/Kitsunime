package com.kitsunime.data.remote.dto

import com.kitsunime.domain.model.KitsuPosterImage


data class PosterImageDto(
    val large: String?,
    val medium: String?,
    val original: String?,
    val small: String?,
    val tiny: String?,
) {
    fun toKitsuPosterImage(): KitsuPosterImage {
        return KitsuPosterImage(
            large = large,
            medium = medium,
            original = original,
            small = small,
            tiny = tiny
        )
    }
}