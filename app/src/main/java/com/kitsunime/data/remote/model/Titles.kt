package com.kitsunime.data.remote.model


import com.google.gson.annotations.SerializedName
import com.kitsunime.domain.model.KitsuTitles

data class Titles(
    @SerializedName("en") val en: String?,
    @SerializedName("en_jp") val enJp: String?,
    @SerializedName("en_us") val enUs: String?,
    @SerializedName("ja_jp") val jaJp: String?,
)

fun Titles.toKitsuTitles(): KitsuTitles {
    return KitsuTitles(
        en = en,
        enJp = enJp,
        enUs = enUs,
        jaJp = jaJp
    )
}