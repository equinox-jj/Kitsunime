package com.kitsunime.data.remote.model


import com.google.gson.annotations.SerializedName
import com.kitsunime.domain.model.KitsuIncluded

data class Included(
    @SerializedName("attributes") val attributes: Attributes?,
    @SerializedName("id") val id: String?,
    @SerializedName("relationships") val relationships: Relationships?,
    @SerializedName("type") val type: String?,
)

fun Included.toKitsuIncluded(): KitsuIncluded {
    return KitsuIncluded(
        attributes = attributes,
        id = id,
        relationships = relationships,
        type = type
    )
}