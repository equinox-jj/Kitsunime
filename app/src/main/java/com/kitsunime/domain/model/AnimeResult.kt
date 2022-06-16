package com.kitsunime.domain.model

import com.kitsunime.data.remote.model.Attributes
import com.kitsunime.data.remote.model.Links
import com.kitsunime.data.remote.model.Relationships

data class AnimeResult (
    val attributes: Attributes?,
    val id: String?,
    val links: Links?,
    val relationships: Relationships?,
    val type: String?
)