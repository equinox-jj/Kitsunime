package com.kitsunime.data.remote.model


import com.google.gson.annotations.SerializedName
import com.kitsunime.domain.model.KitsuLinks

data class Links(
    @SerializedName("first") val first: String?,
    @SerializedName("last") val last: String?,
    @SerializedName("next") val next: String?,
)

fun Links.toKitsuLinks(): KitsuLinks {
    return KitsuLinks(
        first = first,
        last = last,
        next = next
    )
}