package com.kitsunime.data.remote.dto

import com.kitsunime.domain.model.KitsuLinks


data class LinksDto(
    val first: String?,
    val last: String?,
    val next: String?,
) {
    fun toKitsuLinks(): KitsuLinks {
        return KitsuLinks(
            first = first,
            last = last,
            next = next
        )
    }
}