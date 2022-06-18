package com.kitsunime.data.remote.model


import com.google.gson.annotations.SerializedName
import com.kitsunime.domain.model.KitsuAttributes

data class Attributes(
    @SerializedName("averageRating") val averageRating: String?,
    @SerializedName("canonicalTitle") val canonicalTitle: String?,
    @SerializedName("coverImage") val coverImage: CoverImage?,
    @SerializedName("episodeCount") val episodeCount: Int?,
    @SerializedName("episodeLength") val episodeLength: Int?,
    @SerializedName("posterImage") val posterImage: PosterImage?,
    @SerializedName("startDate") val startDate: String?,
    @SerializedName("status") val status: String?,
    @SerializedName("subtype") val subtype: String?,
    @SerializedName("chapterCount") val chapterCount: Int?,
    @SerializedName("volumeCount") val volumeCount: Int?,
    @SerializedName("serialization") val serialization: String?,

    )

fun Attributes.toKitsuAttributes(): KitsuAttributes {
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
        serialization = serialization
    )
}