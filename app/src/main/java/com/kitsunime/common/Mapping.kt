package com.kitsunime.common

import com.kitsunime.data.local.entity.AnimeEntity
import com.kitsunime.data.local.entity.AnimeTrendingEntity
import com.kitsunime.data.local.entity.MangaEntity
import com.kitsunime.data.local.entity.MangaTrendingEntity
import com.kitsunime.data.remote.dto.KitsuResults

fun KitsuResults.toAnimeTrendingEntity(): AnimeTrendingEntity {
    return AnimeTrendingEntity(
        id = id,
        attributes = attributes,
        relationships = relationships,
        type = type
    )
}

fun AnimeTrendingEntity.toAnimeTrending(): KitsuResults {
    return KitsuResults(
        attributes = attributes,
        id = id,
        relationships = relationships,
        type = type
    )
}

fun KitsuResults.toAnimeEntity(): AnimeEntity {
    return AnimeEntity(
        id = id,
        attributes = attributes,
        relationships = relationships,
        type = type
    )
}

fun AnimeEntity.toAnime(): KitsuResults {
    return KitsuResults(
        attributes = attributes,
        id = id,
        relationships = relationships,
        type = type
    )
}

fun KitsuResults.toMangaTrendingEntity(): MangaTrendingEntity {
    return MangaTrendingEntity(
        id = id,
        attributes = attributes,
        relationships = relationships,
        type = type
    )
}

fun MangaTrendingEntity.toMangaTrending(): KitsuResults {
    return KitsuResults(
        attributes = attributes,
        id = id,
        relationships = relationships,
        type = type
    )
}

fun KitsuResults.toMangaEntity(): MangaEntity {
    return MangaEntity(
        id = id,
        attributes = attributes,
        relationships = relationships,
        type = type
    )
}

fun MangaEntity.toManga(): KitsuResults {
    return KitsuResults(
        attributes = attributes,
        id = id,
        relationships = relationships,
        type = type
    )
}