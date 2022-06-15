package com.kitsunime.presentation.anime

import com.kitsunime.domain.model.animelist.AnimeListResponse

data class AnimeUiState(
    val isLoading: Boolean = false,
    val data: AnimeListResponse? = null,
    val error: String = ""
)