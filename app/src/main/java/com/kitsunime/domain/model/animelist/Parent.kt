package com.kitsunime.domain.model.animelist


import com.google.gson.annotations.SerializedName

data class Parent(
    @SerializedName("links")
    val links: Links?
)