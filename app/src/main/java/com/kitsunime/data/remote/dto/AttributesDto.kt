package com.kitsunime.data.remote.dto

import com.kitsunime.domain.model.KitsuAttributes


data class AttributesDto(
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
) {
    fun toKitsuAttributes(): KitsuAttributes {
        return KitsuAttributes(
            averageRating = averageRating,
            canonicalTitle = canonicalTitle,
            coverImage = coverImage,
            episodeCount = episodeCount,
            episodeLength = episodeLength,
            posterImage = posterImage,
            startDate = startDate,
            status = status,
            subtype = subtype,
            chapterCount = chapterCount,
            volumeCount = volumeCount,
            serialization = serialization,
        )
    }
}