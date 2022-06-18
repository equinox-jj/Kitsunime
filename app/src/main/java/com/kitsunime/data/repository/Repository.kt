package com.kitsunime.data.repository

import com.kitsunime.data.local.KitsuDao
import com.kitsunime.data.local.entity.AnimeEntity
import com.kitsunime.data.local.entity.AnimeTrendingEntity
import com.kitsunime.data.remote.KitsuService
import com.kitsunime.data.remote.model.AnimeListResponse
import com.kitsunime.domain.repository.IRepository
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: KitsuService,
    private val dao: KitsuDao,
) : IRepository {

    // Remote Repository
    override suspend fun getAnimeTrendingList(): AnimeListResponse {
        return api.getTrendingAnimeList()
    }

    override suspend fun getAnimeList(): AnimeListResponse {
        return api.getAnimeList()
    }

    override suspend fun getMangaTrendingList(): AnimeListResponse {
        return api.getTrendingMangaList()
    }

    override suspend fun getMangaList(): AnimeListResponse {
        return api.getMangaList()
    }

    // Local Repository
    override suspend fun insertAnimeTrendingDao(animeTrendingEntity: List<AnimeTrendingEntity>) {
        return dao.insertAnimeTrendingDao(animeTrendingEntity)
    }

    override suspend fun getAnimeTrendingDao(): List<AnimeTrendingEntity> {
        return dao.getAnimeTrendingDao()
    }

    override suspend fun deleteAnimeTrendingIdsDao(ids: List<String>) {
        return dao.deleteAnimeTrendingIdsDao(ids)
    }

    override suspend fun insertAnimeDao(animeEntity: List<AnimeEntity>) {
        return dao.insertAnimeDao(animeEntity)
    }

    override suspend fun getAnimeDao(): List<AnimeEntity> {
        return dao.getAnimeDao()
    }

    override suspend fun deleteAnimeIdsDao(ids: List<String>) {
        return dao.deleteAnimeIdsDao(ids)
    }

}