package com.kitsunime.data.remote.model


import com.google.gson.annotations.SerializedName

data class Relationships(
    @SerializedName("categories")
    val categories: Categories?,
    @SerializedName("genres")
    val genres: Genres?,
    @SerializedName("mappings")
    val mappings: Mappings?,
    @SerializedName("mediaRelationships")
    val mediaRelationships: MediaRelationships?,
    @SerializedName("anime")
    val anime: Anime?,
    @SerializedName("manga")
    val manga: Manga?,
    @SerializedName("parent")
    val parent: Parent?
)