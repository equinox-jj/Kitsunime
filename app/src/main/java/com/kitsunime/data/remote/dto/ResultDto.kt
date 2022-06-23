package com.kitsunime.data.remote.dto

import com.kitsunime.data.local.entity.AnimeEntity
import com.kitsunime.data.local.entity.AnimeTrendingEntity
import com.kitsunime.data.local.entity.MangaEntity
import com.kitsunime.data.local.entity.MangaTrendingEntity


data class ResultDto(
    val id: String,
    val attributes: AttributesDto?,
    val relationships: RelationshipsDto?,
    val type: String,
) {
    fun toAnimeEntity(): AnimeEntity {
        return AnimeEntity(
            id = id,
            attributes = attributes?.toKitsuAttributes(),
            relationships = relationships?.toKitsuRelationships(),
            type = type
        )
    }

    fun toAnimeTrendingEntity(): AnimeTrendingEntity {
        return AnimeTrendingEntity(
            id = id,
            attributes = attributes?.toKitsuAttributes(),
            relationships = relationships?.toKitsuRelationships(),
            type = type
        )
    }

    fun toMangaEntity(): MangaEntity {
        return MangaEntity(
            id = id,
            attributes = attributes?.toKitsuAttributes(),
            relationships = relationships?.toKitsuRelationships(),
            type = type
        )
    }

    fun toMangaTrendingEntity(): MangaTrendingEntity {
        return MangaTrendingEntity(
            id = id,
            attributes = attributes?.toKitsuAttributes(),
            relationships = relationships?.toKitsuRelationships(),
            type = type
        )
    }
}

