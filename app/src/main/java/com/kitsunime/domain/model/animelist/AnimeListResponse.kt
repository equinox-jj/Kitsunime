package com.kitsunime.domain.model.animelist


import com.google.gson.annotations.SerializedName

data class AnimeListResponse(
    @SerializedName("data")
    val data: List<Data>,
    @SerializedName("included")
    val included: List<Included>?,
    @SerializedName("links")
    val links: Links?,
)