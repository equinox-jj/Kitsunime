package com.kitsunime.presentation.manga

import com.kitsunime.data.remote.model.Data

data class MangaTrendingUiState(
    val isLoading: Boolean = false,
    val data: List<Data> = emptyList(),
    val error: String = "",
)