package com.kitsunime.data.remote.dto

import com.kitsunime.domain.model.KitsuTiny


data class TinyDto(
    val height: Int?,
    val width: Int?,
) {
    fun toKitsuTiny(): KitsuTiny {
        return KitsuTiny(
            height = height,
            width = width
        )
    }
}