package com.kitsunime.presentation.anime

import com.kitsunime.data.remote.model.AnimeListResponse

data class AnimeUiState(
    val isLoading: Boolean = false,
    val data: AnimeListResponse? = null,
    val error: String = ""
)