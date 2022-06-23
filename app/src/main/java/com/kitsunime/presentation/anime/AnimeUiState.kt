package com.kitsunime.presentation.anime

import com.kitsunime.domain.model.KitsuResult

data class AnimeUiState(
    val isLoading: Boolean = false,
    val data: List<KitsuResult> = emptyList(),
    val error: String = "",
)