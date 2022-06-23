package com.kitsunime.domain.use_case

data class UseCases(
    val getAnimeListUseCase: GetAnimeListUseCase,
    val getAnimeTrendingListUseCase: GetAnimeTrendingListUseCase,
    val getMangaListUseCase: GetMangaListUseCase,
    val getMangaTrendingListUseCase: GetMangaTrendingListUseCase,
)