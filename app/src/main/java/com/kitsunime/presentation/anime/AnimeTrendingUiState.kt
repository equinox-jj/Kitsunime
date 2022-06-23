package com.kitsunime.presentation.anime

import com.kitsunime.domain.model.KitsuResult

data class AnimeTrendingUiState(
    val isLoading: Boolean = false,
    val data: List<KitsuResult> = emptyList(),
    val error: String = "",
)