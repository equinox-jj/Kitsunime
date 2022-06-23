package com.kitsunime.data.remote.dto

import com.kitsunime.domain.model.KitsuCategories


data class CategoriesDto(
    val data: List<ResultDto>?,
    val links: LinksDto?,
) {
    fun toKitsuCategories(): KitsuCategories {
        return KitsuCategories(
            data = data?.map {
                it.toAnimeEntity().toKitsuResult()
                it.toAnimeTrendingEntity().toKitsuResult()
                it.toMangaEntity().toKitsuResult()
                it.toMangaTrendingEntity().toKitsuResult()
            },
            links = links?.toKitsuLinks()
        )
    }
}