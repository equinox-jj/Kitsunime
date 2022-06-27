package com.kitsunime.presentation.manga

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kitsunime.domain.use_case.UseCases
import com.kitsunime.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(
    private val useCases: UseCases,
) : ViewModel() {

    private val _mangaTrendingUiState = MutableStateFlow(MangaUiState())
    val mangaTrendingUiState: StateFlow<MangaUiState> = _mangaTrendingUiState

    private val _mangaUiState = MutableStateFlow(MangaUiState())
    val mangaUiState: StateFlow<MangaUiState> = _mangaUiState

    init {
        getMangaTrendingList()
        getMangaList()
    }

    fun refresh() {
        getMangaTrendingList()
        getMangaList()
    }

    private fun getMangaTrendingList() {
        useCases.getMangaTrendingListUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _mangaTrendingUiState.update { previousState ->
                        previousState.copy(
                            isLoading = false,
                            mangaTrendingData = result.data ?: emptyList()
                        )
                    }
                }
                is Resource.Error -> {
                    _mangaTrendingUiState.update { previousState ->
                        previousState.copy(
                            isLoading = false,
                            mangaTrendingData = result.data ?: emptyList(),
                            error = result.message ?: "An unexpected error occurred."
                        )
                    }
                }
                is Resource.Loading -> {
                    _mangaTrendingUiState.update { previousState ->
                        previousState.copy(
                            isLoading = true,
                            mangaTrendingData = result.data ?: emptyList()
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getMangaList() {
        useCases.getMangaListUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _mangaUiState.update { previousState ->
                        previousState.copy(
                            isLoading = false,
                            mangaData = result.data ?: emptyList()
                        )
                    }
                }
                is Resource.Error -> {
                    _mangaUiState.update { previousState ->
                        previousState.copy(
                            isLoading = false,
                            mangaData = result.data ?: emptyList(),
                            error = result.message ?: "An unexpected error occurred."
                        )
                    }
                }
                is Resource.Loading -> {
                    _mangaUiState.update { previousState ->
                        previousState.copy(
                            isLoading = true,
                            mangaData = result.data ?: emptyList()
                        )
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

}