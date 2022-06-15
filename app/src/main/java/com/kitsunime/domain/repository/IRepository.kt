package com.kitsunime.domain.repository

import com.kitsunime.domain.model.animelist.AnimeListResponse

interface IRepository {

    suspend fun getAnimeTrendingList(): AnimeListResponse
    suspend fun getAnimeList(): AnimeListResponse

}