package com.kitsunime.data.remote.dto

import com.kitsunime.domain.model.KitsuIncluded


data class IncludedDto(
    val attributes: AttributesDto?,
    val id: String?,
    val relationships: RelationshipsDto?,
    val type: String?,
) {
    fun toKitsuIncluded(): KitsuIncluded {
        return KitsuIncluded(
            attributes = attributes?.toKitsuAttributes(),
            id = id,
            relationships = relationships?.toKitsuRelationships(),
            type = type
        )
    }
}