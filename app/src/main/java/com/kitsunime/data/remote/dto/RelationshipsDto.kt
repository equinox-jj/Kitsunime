package com.kitsunime.data.remote.dto

import com.kitsunime.domain.model.KitsuRelationships


data class RelationshipsDto(
    val categories: CategoriesDto?,
    val genres: GenresDto?,
) {
    fun toKitsuRelationships(): KitsuRelationships {
        return KitsuRelationships(
            categories = categories?.toKitsuCategories(),
            genres = genres?.toKitsuGenres(),
        )
    }
}