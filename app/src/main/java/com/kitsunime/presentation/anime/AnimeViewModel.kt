package com.kitsunime.presentation.anime

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kitsunime.common.Resource
import com.kitsunime.domain.use_case.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
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
        useCases.getAnimeTrendingListUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _animeTrendingUiState.update { previousState ->
                        previousState.copy(
                            isLoading = false,
                            data = result.data ?: emptyList()
                        )
                    }
                }
                is Resource.Error -> {
                    _animeTrendingUiState.update { previousState ->
                        previousState.copy(
                            isLoading = false,
                            data = result.data ?: emptyList(),
                            error = result.message ?: "An unexpected error occurred."
                        )
                    }
                }
                is Resource.Loading -> {
                    _animeTrendingUiState.update { previousState ->
                        previousState.copy(
                            isLoading = true,
                            data = result.data ?: emptyList()
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getAnimeList() {
        useCases.getAnimeListUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _animeUiState.update { previousState ->
                        previousState.copy(
                            isLoading = false,
                            data = result.data ?: emptyList()
                        )
                    }
                }
                is Resource.Error -> {
                    _animeUiState.update { previousState ->
                        previousState.copy(
                            isLoading = false,
                            data = result.data ?: emptyList(),
                            error = result.message ?: "An unexpected error occurred."
                        )
                    }
                }
                is Resource.Loading -> {
                    _animeUiState.update { previousState ->
                        previousState.copy(
                            isLoading = true,
                            data = result.data ?: emptyList()
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

}