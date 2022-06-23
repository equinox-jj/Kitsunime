package com.kitsunime.domain.model

import com.kitsunime.data.remote.dto.CoverImageDto
import com.kitsunime.data.remote.dto.PosterImageDto

data class KitsuAttributes(
    val averageRating: String?,
    val canonicalTitle: String?,
    val coverImage: CoverImageDto?,
    val episodeCount: Int?,
    val episodeLength: Int?,
    val posterImage: PosterImageDto?,
    val startDate: String?,
    val status: String?,
    val subtype: String?,
    val chapterCount: Int?,
    val volumeCount: Int?,
    val serialization: String?,
)
