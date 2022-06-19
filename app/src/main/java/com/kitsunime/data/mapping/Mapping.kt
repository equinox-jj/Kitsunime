package com.kitsunime.data.mapping

import com.kitsunime.data.local.entity.AnimeEntity
import com.kitsunime.data.local.entity.AnimeTrendingEntity
import com.kitsunime.data.local.entity.MangaEntity
import com.kitsunime.data.local.entity.MangaTrendingEntity
import com.kitsunime.data.remote.model.Data

fun Data.toAnimeTrendingEntity(): AnimeTrendingEntity {
    return AnimeTrendingEntity(
        id = id,
        attributes = attributes,
        relationships = relationships,
        type = type
    )
}

fun AnimeTrendingEntity.toAnimeTrending(): Data {
    return Data(
        attributes = attributes,
        id = id,
        relationships = relationships,
        type = type
    )
}

fun Data.toAnimeEntity(): AnimeEntity {
    return AnimeEntity(
        id = id,
        attributes = attributes,
        relationships = relationships,
        type = type
    )
}

fun AnimeEntity.toAnime(): Data {
    return Data(
        attributes = attributes,
        id = id,
        relationships = relationships,
        type = type
    )
}

fun Data.toMangaTrendingEntity(): MangaTrendingEntity {
    return MangaTrendingEntity(
        id = id,
        attributes = attributes,
        relationships = relationships,
        type = type
    )
}

fun MangaTrendingEntity.toMangaTrending(): Data {
    return Data(
        attributes = attributes,
        id = id,
        relationships = relationships,
        type = type
    )
}

fun Data.toMangaEntity(): MangaEntity {
    return MangaEntity(
        id = id,
        attributes = attributes,
        relationships = relationships,
        type = type
    )
}

fun MangaEntity.toManga(): Data {
    return Data(
        attributes = attributes,
        id = id,
        relationships = relationships,
        type = type
    )
}