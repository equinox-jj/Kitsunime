package com.kitsunime.data.remote.dto

import com.kitsunime.domain.model.KitsuSmall


data class SmallDto(
    val height: Int?,
    val width: Int?,
) {
    fun toKitsuSmall(): KitsuSmall {
        return KitsuSmall(
            height = height,
            width = width
        )
    }
}