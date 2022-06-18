package com.kitsunime.domain.model

import com.kitsunime.data.remote.model.CoverImage
import com.kitsunime.data.remote.model.PosterImage

data class KitsuAttributes(
    val averageRating: String?,
    val canonicalTitle: String?,
    val coverImage: CoverImage?,
    val episodeCount: Int?,
    val episodeLength: Int?,
    val posterImage: PosterImage?,
    val startDate: String?,
    val status: String?,
    val subtype: String?,
    val chapterCount: Int?,
    val volumeCount: Int?,
    val serialization: String?,
)
