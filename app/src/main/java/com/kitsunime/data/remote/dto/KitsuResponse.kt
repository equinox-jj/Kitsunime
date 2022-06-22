package com.kitsunime.data.remote.dto


data class KitsuResponse(
     val data: List<KitsuResults>,
     val kitsuIncluded: List<KitsuIncluded>?,
     val links: Links?,
)