package com.kitsunime.presentation.discover

import androidx.lifecycle.ViewModel
import com.kitsunime.domain.use_case.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModel @Inject constructor(
    private val useCases: UseCases,
) : ViewModel() {

val getAnimePagingUseCase = useCases.getAnimePagingUseCase()

}