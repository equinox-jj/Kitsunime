package com.kitsunime.domain.repository

import com.kitsunime.data.remote.model.AnimeListResponse

interface IRepository {

    suspend fun getAnimeTrendingList(): AnimeListResponse
    suspend fun getAnimeList(): AnimeListResponse

}