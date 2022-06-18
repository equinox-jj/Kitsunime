package com.kitsunime.domain.model

import com.kitsunime.data.remote.model.Attributes
import com.kitsunime.data.remote.model.Relationships

data class KitsuResult (
    val attributes: Attributes?,
    val id: String?,
    val relationships: Relationships?,
    val type: String?
)