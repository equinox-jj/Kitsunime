package com.kitsunime.domain.model.animelist


import com.google.gson.annotations.SerializedName

data class MediaRelationships(
    @SerializedName("links")
    val links: Links?
)