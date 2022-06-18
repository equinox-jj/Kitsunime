package com.kitsunime.data.remote.model


import com.google.gson.annotations.SerializedName
import com.kitsunime.domain.model.KitsuCategories

data class Categories(
    @SerializedName("data") val data: List<Data>?,
    @SerializedName("links") val links: Links?,
)

fun Categories.toKitsuCategories(): KitsuCategories {
    return KitsuCategories(
        data = data,
        links = links
    )
}