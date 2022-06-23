package com.kitsunime.presentation.manga

import com.kitsunime.domain.model.KitsuResult

data class MangaTrendingUiState(
    val isLoading: Boolean = false,
    val data: List<KitsuResult> = emptyList(),
    val error: String = "",
)