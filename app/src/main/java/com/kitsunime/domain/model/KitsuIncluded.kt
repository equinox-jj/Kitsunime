package com.kitsunime.domain.model

import com.kitsunime.data.remote.model.Attributes
import com.kitsunime.data.remote.model.Relationships

data class KitsuIncluded(
    val attributes: Attributes?,
    val id: String?,
    val relationships: Relationships?,
    val type: String?,
)