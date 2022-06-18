package com.kitsunime.domain.repository

import com.kitsunime.data.local.entity.AnimeEntity
import com.kitsunime.data.local.entity.AnimeTrendingEntity
import com.kitsunime.data.remote.model.AnimeListResponse

interface IRepository {

    suspend fun getAnimeTrendingList(): AnimeListResponse
    suspend fun getAnimeList(): AnimeListResponse
    suspend fun getMangaTrendingList(): AnimeListResponse
    suspend fun getMangaList(): AnimeListResponse

    suspend fun insertAnimeTrendingDao(animeTrendingEntity: List<AnimeTrendingEntity>)
    suspend fun getAnimeTrendingDao(): List<AnimeTrendingEntity>
    suspend fun deleteAnimeTrendingIdsDao(ids: List<String>)

    suspend fun insertAnimeDao(animeEntity: List<AnimeEntity>)
    suspend fun getAnimeDao(): List<AnimeEntity>
    suspend fun deleteAnimeIdsDao(ids: List<String>)

}