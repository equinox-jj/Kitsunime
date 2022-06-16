package com.kitsunime.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.kitsunime.data.remote.model.Data
import com.kitsunime.data.remote.model.Included
import com.kitsunime.data.remote.model.Links
import com.kitsunime.domain.model.AnimeList

data class AnimeListDto(
    @SerializedName("data")
    val data: List<Data>,
    @SerializedName("included")
    val included: List<Included>?,
    @SerializedName("links")
    val links: Links?,
)

fun AnimeListDto.toAnimeList(): AnimeList {
    return AnimeList(
        data = data,
        included = included,
        links = links
    )
}
