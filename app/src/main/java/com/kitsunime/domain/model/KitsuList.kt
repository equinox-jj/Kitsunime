package com.kitsunime.domain.model

import com.kitsunime.data.remote.model.Data
import com.kitsunime.data.remote.model.Included
import com.kitsunime.data.remote.model.Links

data class KitsuList(
    val data: List<Data>,
    val included: List<Included>?,
    val links: Links?,
)