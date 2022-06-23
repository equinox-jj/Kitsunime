package com.kitsunime.data.remote.dto

import com.kitsunime.domain.model.KitsuTitles


data class TitlesDto(
    val en: String?,
    val enJp: String?,
    val enUs: String?,
    val jaJp: String?,
) {
    fun toKitsuTitles(): KitsuTitles {
        return KitsuTitles(
            en = en,
            enJp = enJp,
            enUs = enUs,
            jaJp = jaJp
        )
    }
}