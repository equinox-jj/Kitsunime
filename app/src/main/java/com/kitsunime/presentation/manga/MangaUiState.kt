package com.kitsunime.presentation.manga

import com.kitsunime.domain.model.KitsuResult

data class MangaUiState(
    val isLoading: Boolean = false,
    val mangaTrendingData: List<KitsuResult> = emptyList(),
    val mangaData: List<KitsuResult> = emptyList(),
    val error: String = "",
)