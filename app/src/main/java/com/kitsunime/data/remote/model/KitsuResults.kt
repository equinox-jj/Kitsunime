package com.kitsunime.data.remote.model


import com.google.gson.annotations.SerializedName

data class KitsuResults(
    @SerializedName("id") val id: String,
    @SerializedName("attributes") val attributes: Attributes,
    @SerializedName("relationships") val relationships: Relationships,
    @SerializedName("type") val type: String,
)

