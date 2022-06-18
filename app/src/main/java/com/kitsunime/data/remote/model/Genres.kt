package com.kitsunime.data.remote.model


import com.google.gson.annotations.SerializedName
import com.kitsunime.domain.model.KitsuGenres

data class Genres(
    @SerializedName("links") val links: Links?,
)

fun Genres.toKitsuGenres(): KitsuGenres {
    return KitsuGenres(
        links = links
    )
}