package com.kitsunime.presentation.manga

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kitsunime.common.Resource
import com.kitsunime.domain.use_case.GetMangaListUseCase
import com.kitsunime.domain.use_case.GetMangaTrendingListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(
    private val getMangaTrendingListUseCase: GetMangaTrendingListUseCase,
    private val getMangaListUseCase: GetMangaListUseCase,
) : ViewModel() {

    private val _mangaTrendingUiState = MutableStateFlow(MangaTrendingUiState())
    val mangaTrendingUiState: StateFlow<MangaTrendingUiState> = _mangaTrendingUiState

    private val _mangaUiState = MutableStateFlow(MangaUiState())
    val mangaUiState: StateFlow<MangaUiState> = _mangaUiState

    init {
        getMangaTrendingList()
        getMangaList()
    }

    private fun getMangaTrendingList() {
        getMangaTrendingListUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _mangaTrendingUiState.value = MangaTrendingUiState(isLoading = false, data = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _mangaTrendingUiState.value = MangaTrendingUiState(isLoading = false, data = result.data ?: emptyList(), error = result.message ?: "An unexpected error occurred.")
                }
                is Resource.Loading -> {
                    _mangaTrendingUiState.value = MangaTrendingUiState(isLoading = true, data = result.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getMangaList() {
        getMangaListUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _mangaUiState.value = MangaUiState(isLoading = false, data = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _mangaUiState.value = MangaUiState(isLoading = false, data = result.data ?: emptyList(), error = result.message ?: "An unexpected error occurred.")
                }
                is Resource.Loading -> {
                    _mangaUiState.value = MangaUiState(isLoading = true, data = result.data ?: emptyList())
                }
            }
        }.launchIn(viewModelScope)
    }

}