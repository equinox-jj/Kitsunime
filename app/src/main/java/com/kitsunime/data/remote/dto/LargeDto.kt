package com.kitsunime.data.remote.dto

import com.kitsunime.domain.model.KitsuLarge


data class LargeDto(
    val height: Int?,
    val width: Int?,
) {
    fun toKitsuLarge(): KitsuLarge {
        return KitsuLarge(
            height = height,
            width = width
        )
    }
}