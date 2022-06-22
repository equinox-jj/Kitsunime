package com.kitsunime.data.remote.dto


data class Attributes(
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