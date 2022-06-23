package com.kitsunime.data.remote.dto

import com.kitsunime.domain.model.KitsuGenres


data class GenresDto(
    val links: LinksDto?,
) {
    fun toKitsuGenres(): KitsuGenres {
        return KitsuGenres(
            links = links?.toKitsuLinks()
        )
    }
}