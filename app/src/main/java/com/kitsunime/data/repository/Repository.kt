package com.kitsunime.data.repository

import com.kitsunime.data.remote.AnimeService
import com.kitsunime.data.remote.MangaService
import com.kitsunime.data.remote.model.AnimeListResponse
import com.kitsunime.domain.repository.IRepository
import javax.inject.Inject

class Repository @Inject constructor(
    private val animeService: AnimeService,
    private val mangaService: MangaService
) : IRepository {

    override suspend fun getAnimeTrendingList(): AnimeListResponse {
        return animeService.getTrendingAnimeList()
    }

    override suspend fun getAnimeList(): AnimeListResponse {
        return animeService.getAnimeList()
    }

}