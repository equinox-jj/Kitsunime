package com.kitsunime.data.remote.model


import com.google.gson.annotations.SerializedName
import com.kitsunime.domain.model.KitsuRelationships

data class Relationships(
    @SerializedName("categories") val categories: Categories?,
    @SerializedName("genres") val genres: Genres?,
)

fun Relationships.toKitsuRelationships(): KitsuRelationships {
    return KitsuRelationships(
        categories = categories,
        genres = genres
    )
}