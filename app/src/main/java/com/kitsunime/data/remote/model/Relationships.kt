package com.kitsunime.data.remote.model


import com.google.gson.annotations.SerializedName

data class Relationships(
    @SerializedName("categories") val categories: Categories?,
    @SerializedName("genres") val genres: Genres?,
)