package com.kitsunime.presentation.anime

import com.kitsunime.data.remote.model.KitsuResults

data class AnimeUiState(
    val isLoading: Boolean = false,
    val data: List<KitsuResults> = emptyList(),
    val error: String = "",
)