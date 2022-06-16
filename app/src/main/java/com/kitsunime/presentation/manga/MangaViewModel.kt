package com.kitsunime.presentation.manga

import androidx.lifecycle.ViewModel
import com.kitsunime.domain.use_case.GetMangaListUseCase
import com.kitsunime.domain.use_case.GetMangaTrendingListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(
    private val getMangaTrendingListUseCase: GetMangaTrendingListUseCase,
    private val getMangaListUseCase: GetMangaListUseCase,
) : ViewModel() {



}