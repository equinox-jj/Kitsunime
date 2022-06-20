package com.kitsunime.data.remote.model


data class KitsuResponse(
     val data: List<KitsuResults>,
     val kitsuIncluded: List<KitsuIncluded>?,
     val links: Links?,
)