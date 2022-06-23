package com.kitsunime.domain.model

data class KitsuResponses(
    val data: List<KitsuResult>,
    val kitsuIncluded: List<KitsuIncluded>?,
    val links: KitsuLinks?,
)
