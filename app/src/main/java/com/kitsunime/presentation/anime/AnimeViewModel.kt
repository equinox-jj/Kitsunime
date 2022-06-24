package com.kitsunime.presentation.anime

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kitsunime.common.Resource
import com.kitsunime.domain.use_case.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val useCases: UseCases,
) : ViewModel() {

    private val _animeTrendingUiState = MutableStateFlow(AnimeTrendingUiState())
    val animeTrendingUiState: StateFlow<AnimeTrendingUiState> = _animeTrendingUiState

    private val _animeUiState = MutableStateFlow(AnimeUiState())
    val animeUiState: StateFlow<AnimeUiState> = _animeUiState

    init {
        getAnimeTrendingList()
        getAnimeList()
    }

    fun refresh() {
        getAnimeTrendingList()
        getAnimeList()
    }

    private fun getAnimeTrendingList() {
        viewModelScope.launch {
            useCases.getAnimeTrendingListUseCase().onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        _animeTrendingUiState.value = AnimeTrendingUiState(isLoading = false, data = result.data ?: emptyList())
                    }
                    is Resource.Error -> {
                        _animeTrendingUiState.value = AnimeTrendingUiState(isLoading = false, data = result.data ?: emptyList(), error = result.message ?: "An unexpected error occurred.")
                    }
                    is Resource.Loading -> {
                        _animeTrendingUiState.value = AnimeTrendingUiState(isLoading = true, data = result.data ?: emptyList())
                    }
                }
            }.launchIn(this)
        }
    }

    private fun getAnimeList() {
        viewModelScope.launch {
            useCases.getAnimeListUseCase().onEach { result ->
                when (result) {
                    is Resource.Success -> {
                        _animeUiState.value = AnimeUiState(isLoading = false, data = result.data ?: emptyList())
                    }
                    is Resource.Error -> {
                        _animeUiState.value = AnimeUiState(isLoading = false, data = result.data ?: emptyList(), error = result.message ?: "An unexpected error occurred.")
                    }
                    is Resource.Loading -> {
                        _animeUiState.value = AnimeUiState(isLoading = true, data = result.data ?: emptyList())
                    }
                }
            }.launchIn(this)
        }
    }

}