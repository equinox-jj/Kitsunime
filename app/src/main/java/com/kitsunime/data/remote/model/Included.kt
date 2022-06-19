package com.kitsunime.data.remote.model


import com.google.gson.annotations.SerializedName

data class Included(
    @SerializedName("attributes") val attributes: Attributes?,
    @SerializedName("id") val id: String?,
    @SerializedName("relationships") val relationships: Relationships?,
    @SerializedName("type") val type: String?,
)