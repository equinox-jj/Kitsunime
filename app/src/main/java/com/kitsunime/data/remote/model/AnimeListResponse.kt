package com.kitsunime.data.remote.model


import com.google.gson.annotations.SerializedName
import com.kitsunime.domain.model.KitsuList

data class AnimeListResponse(
    @SerializedName("data") val data: List<Data>,
    @SerializedName("included") val included: List<Included>?,
    @SerializedName("links") val links: Links?,
)

fun AnimeListResponse.toKitsuList(): KitsuList {
    return KitsuList(
        data = data,
        included = included,
        links = links
    )
}