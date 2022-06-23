package com.kitsunime.domain.use_case

import com.kitsunime.domain.use_case.anime_use_cases.GetAnimeListUseCase
import com.kitsunime.domain.use_case.anime_use_cases.GetAnimeTrendingListUseCase
import com.kitsunime.domain.use_case.manga_use_cases.GetMangaListUseCase
import com.kitsunime.domain.use_case.manga_use_cases.GetMangaTrendingListUseCase

data class UseCases(
    val getAnimeListUseCase: GetAnimeListUseCase,
    val getAnimeTrendingListUseCase: GetAnimeTrendingListUseCase,
    val getMangaListUseCase: GetMangaListUseCase,
    val getMangaTrendingListUseCase: GetMangaTrendingListUseCase,
)