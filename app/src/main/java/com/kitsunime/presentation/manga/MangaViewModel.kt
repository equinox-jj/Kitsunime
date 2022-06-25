package com.kitsunime.presentation.manga

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kitsunime.common.Resource
import com.kitsunime.domain.use_case.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(
    private val useCases: UseCases,
) : ViewModel() {

    private val _mangaTrendingUiState = MutableStateFlow(MangaTrendingUiState())
    val mangaTrendingUiState: StateFlow<MangaTrendingUiState> = _mangaTrendingUiState

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
                    _mangaTrendingUiState.value = mangaTrendingUiState.value.copy(isLoading = false,
                        data = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _mangaTrendingUiState.value = mangaTrendingUiState.value.copy(isLoading = false,
                        data = result.data ?: emptyList(),
                        error = result.message ?: "An unexpected error occurred.")
                }
                is Resource.Loading -> {
                    _mangaTrendingUiState.value = mangaTrendingUiState.value.copy(isLoading = true,
                        data = result.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getMangaList() {
        useCases.getMangaListUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _mangaUiState.value = mangaUiState.value.copy(isLoading = false,
                        data = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _mangaUiState.value = mangaUiState.value.copy(isLoading = false,
                        data = result.data ?: emptyList(),
                        error = result.message ?: "An unexpected error occurred.")
                }
                is Resource.Loading -> {
                    _mangaUiState.value =
                        mangaUiState.value.copy(isLoading = true, data = result.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }

}