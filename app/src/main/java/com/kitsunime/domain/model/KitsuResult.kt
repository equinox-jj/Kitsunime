package com.kitsunime.domain.model

data class KitsuResult(
    val attributes: KitsuAttributes?,
    val id: String,
    val relationships: KitsuRelationships?,
    val type: String,
)