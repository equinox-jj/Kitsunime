package com.kitsunime.presentation.discover

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.kitsunime.domain.use_case.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModel @Inject constructor(
    private val useCases: UseCases,
) : ViewModel() {

    private val _discAnimeUiState = MutableStateFlow(DiscoverAnimeUiState())
    val discAnimeUiState: StateFlow<DiscoverAnimeUiState> = _discAnimeUiState

    init {
        discAnime()
    }

    private fun discAnime() {
        viewModelScope.launch {
            useCases.getAnimePagingUseCase().cachedIn(viewModelScope).collect { data ->
                    _discAnimeUiState.update { uiState ->
                        uiState.copy(data = data)
                    }
                }
        }
    }


}