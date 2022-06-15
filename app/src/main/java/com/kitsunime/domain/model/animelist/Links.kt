package com.kitsunime.domain.model.animelist


import com.google.gson.annotations.SerializedName

data class Links(
    @SerializedName("self")
    val self: String?,
    @SerializedName("related")
    val related: String?,
    @SerializedName("first")
    val first: String?,
    @SerializedName("last")
    val last: String?,
    @SerializedName("next")
    val next: String?
)