package com.kitsunime.domain.model

import com.kitsunime.data.remote.model.Categories
import com.kitsunime.data.remote.model.Genres

data class KitsuRelationships(
    val categories: Categories?,
    val genres: Genres?,
)
