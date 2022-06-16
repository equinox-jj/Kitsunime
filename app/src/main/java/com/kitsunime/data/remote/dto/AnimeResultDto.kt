package com.kitsunime.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.kitsunime.data.remote.model.Attributes
import com.kitsunime.data.remote.model.Links
import com.kitsunime.data.remote.model.Relationships
import com.kitsunime.domain.model.AnimeResult

data class AnimeResultDto(
    @SerializedName("attributes")
    val attributes: Attributes?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("links")
    val links: Links?,
    @SerializedName("relationships")
    val relationships: Relationships?,
    @SerializedName("type")
    val type: String?,
)

fun AnimeResultDto.toAnimeResult(): AnimeResult {
    return AnimeResult(
        attributes = attributes,
        id = id,
        links = links,
        relationships = relationships,
        type = type
    )
}