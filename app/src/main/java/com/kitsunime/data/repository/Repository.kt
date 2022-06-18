package com.kitsunime.data.repository

import com.kitsunime.common.Resource
import com.kitsunime.data.local.KitsuDao
import com.kitsunime.data.local.entity.AnimeEntity
import com.kitsunime.data.local.entity.AnimeTrendingEntity
import com.kitsunime.data.remote.KitsuService
import com.kitsunime.data.remote.model.AnimeListResponse
import com.kitsunime.data.remote.model.Data
import com.kitsunime.domain.repository.IRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class Repository @Inject constructor(
    private val api: KitsuService,
    private val dao: KitsuDao,
) : IRepository {

    // Remote Repository
    override fun getAnimeTrendingList(): Flow<Resource<List<Data>>> = flow {
        emit(Resource.Loading())

        // Read The Current Data from Database
        val kitsuDao = dao.getAnimeTrendingDao().map { it.toAnimeTrending() }
        emit(Resource.Loading(data = kitsuDao))

        try {
            val remoteResponse = api.getTrendingAnimeList().data // Initiate Api Call
            dao.deleteAnimeTrendingIdsDao(remoteResponse.map { it.id }) // Delete The Anime Data From ROOM
            dao.insertAnimeTrendingDao(remoteResponse.map { it.toAnimeTrendingEntity() }) // Replace With New Anime Data
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred.",
                data = kitsuDao))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "No Internet Connection.",
                data = kitsuDao))
        }

        // Emit The Data To UI Layer
        val newKitsuDao = dao.getAnimeTrendingDao().map { it.toAnimeTrending() }
        emit(Resource.Success(newKitsuDao))
    }

    override fun getAnimeList(): Flow<Resource<List<Data>>> = flow {
        emit(Resource.Loading())

        val kitsuDao = dao.getAnimeDao().map { it.toAnime() }
        emit(Resource.Loading(data = kitsuDao))

        try {
            val remoteResponse = api.getAnimeList().data
            dao.deleteAnimeIdsDao(remoteResponse.map { it.id })
            dao.insertAnimeDao(remoteResponse.map { it.toAnimeEntity() })
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred.",
                data = kitsuDao))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "No Internet Connection",
                data = kitsuDao))
        }

        val newKitsuDao = dao.getAnimeDao().map { it.toAnime() }
        emit(Resource.Success(newKitsuDao))
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