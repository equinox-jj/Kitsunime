package com.kitsunime.presentation.discover

import androidx.paging.PagingData
import com.kitsunime.domain.model.KitsuResult

data class DiscoverAnimeUiState(
    val data: PagingData<KitsuResult>? = null,
)