package com.kitsunime.presentation.manga

import com.kitsunime.data.remote.dto.KitsuResults

data class MangaUiState(
    val isLoading: Boolean = false,
    val data: List<KitsuResults> = emptyList(),
    val error: String = "",
)