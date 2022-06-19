package com.kitsunime.domain.repository

import com.kitsunime.common.Resource
import com.kitsunime.data.local.entity.AnimeEntity
import com.kitsunime.data.local.entity.AnimeTrendingEntity
import com.kitsunime.data.local.entity.MangaEntity
import com.kitsunime.data.local.entity.MangaTrendingEntity
import com.kitsunime.data.remote.model.KitsuResults
import kotlinx.coroutines.flow.Flow

interface IRepository {

    fun getAnimeTrendingList(): Flow<Resource<List<KitsuResults>>>
    fun getAnimeList(): Flow<Resource<List<KitsuResults>>>
    fun getMangaTrendingList(): Flow<Resource<List<KitsuResults>>>
    fun getMangaList(): Flow<Resource<List<KitsuResults>>>

    suspend fun insertAnimeTrendingDao(animeTrendingEntity: List<AnimeTrendingEntity>)
    suspend fun getAnimeTrendingDao(): List<AnimeTrendingEntity>
    suspend fun deleteAnimeTrendingIdsDao(ids: List<String>)

    suspend fun insertAnimeDao(animeEntity: List<AnimeEntity>)
    suspend fun getAnimeDao(): List<AnimeEntity>
    suspend fun deleteAnimeIdsDao(ids: List<String>)

    suspend fun insertMangaTrendingDao(mangaTrendingEntity: List<MangaTrendingEntity>)
    suspend fun getMangaTrendingDao(): List<MangaTrendingEntity>
    suspend fun deleteMangaTrendingIdsDao(ids: List<String>)

    suspend fun insertMangaDao(mangaEntity: List<MangaEntity>)
    suspend fun getMangaDao(): List<MangaEntity>
    suspend fun deleteMangaIdsDao(ids: List<String>)

}