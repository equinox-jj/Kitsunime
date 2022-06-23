package com.kitsunime.data.remote.dto

import com.kitsunime.domain.model.KitsuResponses


data class ResponseDto(
    val data: List<ResultDto>,
    val kitsuIncluded: List<IncludedDto>?,
    val links: LinksDto?,
) {
    fun toKitsuResponses(): KitsuResponses {
        return KitsuResponses(
            data = data.map {
                it.toAnimeEntity().toKitsuResult()
                it.toAnimeTrendingEntity().toKitsuResult()
                it.toMangaEntity().toKitsuResult()
                it.toMangaTrendingEntity().toKitsuResult()
            },
            kitsuIncluded = kitsuIncluded?.map { it.toKitsuIncluded() },
            links = links?.toKitsuLinks()
        )
    }
}