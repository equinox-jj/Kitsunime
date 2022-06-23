package com.kitsunime.data.remote.dto

import com.kitsunime.domain.model.KitsuMedium


data class MediumDto(
    val height: Int?,
    val width: Int?,
) {
    fun toKitsuMedium(): KitsuMedium {
        return KitsuMedium(
            height = height,
            width = width
        )
    }
}