package com.kitsunime.data.remote.dto

import com.kitsunime.domain.model.KitsuCoverImage


data class CoverImageDto(
    val large: String?,
    val original: String?,
    val small: String?,
    val tiny: String?,
) {
    fun toKitsuCoverImage(): KitsuCoverImage {
        return KitsuCoverImage(
            large = large,
            original = original,
            small = small,
            tiny = tiny
        )
    }
}