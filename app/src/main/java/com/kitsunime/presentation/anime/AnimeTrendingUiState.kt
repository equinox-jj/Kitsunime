package com.kitsunime.presentation.anime

import com.kitsunime.data.remote.model.AnimeListResponse
import com.kitsunime.data.remote.model.Data

data class AnimeTrendingUiState(
    val isLoading: Boolean = false,
    val data: List<Data> = emptyList(),
    val error: String = ""
)