package com.kitsunime.domain.repository

import com.kitsunime.common.Resource
import com.kitsunime.data.local.entity.AnimeEntity
import com.kitsunime.data.local.entity.AnimeTrendingEntity
import com.kitsunime.data.remote.model.AnimeListResponse
import com.kitsunime.data.remote.model.Data
import kotlinx.coroutines.flow.Flow

interface IRepository {

    fun getAnimeTrendingList(): Flow<Resource<List<Data>>>
    fun getAnimeList(): Flow<Resource<List<Data>>>
    suspend fun getMangaTrendingList(): AnimeListResponse
    suspend fun getMangaList(): AnimeListResponse

    suspend fun insertAnimeTrendingDao(animeTrendingEntity: List<AnimeTrendingEntity>)
    suspend fun getAnimeTrendingDao(): List<AnimeTrendingEntity>
    suspend fun deleteAnimeTrendingIdsDao(ids: List<String>)

    suspend fun insertAnimeDao(animeEntity: List<AnimeEntity>)
    suspend fun getAnimeDao(): List<AnimeEntity>
    suspend fun deleteAnimeIdsDao(ids: List<String>)

}