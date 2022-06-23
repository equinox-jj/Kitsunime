package com.kitsunime.domain.model

import com.kitsunime.data.remote.dto.LinksDto

data class KitsuList(
    val data: List<KitsuResult>,
    val included: List<KitsuIncluded>?,
    val links: LinksDto?,
)