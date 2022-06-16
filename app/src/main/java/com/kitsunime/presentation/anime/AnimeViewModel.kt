package com.kitsunime.presentation.anime

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kitsunime.common.Resource
import com.kitsunime.domain.use_case.GetAnimeListUseCase
import com.kitsunime.domain.use_case.GetAnimeTrendingListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val getAnimeListUseCase: GetAnimeListUseCase,
    private val getAnimeTrendingListUseCase: GetAnimeTrendingListUseCase,
) : ViewModel() {

    private val _trendingAnimeUiState = MutableStateFlow(AnimeTrendingUiState())
    val trendingAnimeUiState: StateFlow<AnimeTrendingUiState> = _trendingAnimeUiState

    private val _animeUiState = MutableStateFlow(AnimeUiState())
    val animeUiState: StateFlow<AnimeUiState> = _animeUiState

    init {
        getAnimeTrendingList()
        getAnimeList()
    }

    private fun getAnimeTrendingList() {
        getAnimeTrendingListUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _trendingAnimeUiState.value = AnimeTrendingUiState(data = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _trendingAnimeUiState.value = AnimeTrendingUiState(error = result.message ?: "An unexpected error occurred.")
                }
                is Resource.Loading -> {
                    _trendingAnimeUiState.value = AnimeTrendingUiState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getAnimeList() {
        getAnimeListUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _animeUiState.value = AnimeUiState(data = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _animeUiState.value = AnimeUiState(error = result.message ?: "An unexpected error occurred.")
                }
                is Resource.Loading -> {
                    _animeUiState.value = AnimeUiState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}