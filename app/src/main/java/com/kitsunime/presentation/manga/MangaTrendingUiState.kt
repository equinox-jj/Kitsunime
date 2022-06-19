package com.kitsunime.presentation.manga

import com.kitsunime.data.remote.model.KitsuResults

data class MangaTrendingUiState(
    val isLoading: Boolean = false,
    val data: List<KitsuResults> = emptyList(),
    val error: String = "",
)