package com.kitsunime.data.repository

import com.kitsunime.common.Resource
import com.kitsunime.data.local.KitsuDao
import com.kitsunime.data.local.entity.AnimeEntity
import com.kitsunime.data.local.entity.AnimeTrendingEntity
import com.kitsunime.data.local.entity.MangaEntity
import com.kitsunime.data.local.entity.MangaTrendingEntity
import com.kitsunime.data.mapping.*
import com.kitsunime.data.remote.KitsuService
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

        val kitsuDao = dao.getAnimeTrendingDao().map { it.toAnimeTrending() }
        emit(Resource.Loading(data = kitsuDao))

        try {
            val remoteResponse = api.getTrendingAnimeList().data
            dao.deleteAnimeTrendingIdsDao(remoteResponse.map { it.id })
            dao.insertAnimeTrendingDao(remoteResponse.map { it.toAnimeTrendingEntity() })
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred.", data = kitsuDao))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "No Internet Connection.", data = kitsuDao))
        }

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
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred.", data = kitsuDao))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "No Internet Connection", data = kitsuDao))
        }

        val newKitsuDao = dao.getAnimeDao().map { it.toAnime() }
        emit(Resource.Success(newKitsuDao))
    }

    override fun getMangaTrendingList(): Flow<Resource<List<Data>>> = flow {
        emit(Resource.Loading())

        val kitsuDao = dao.getMangaTrendingDao().map { it.toMangaTrending() }
        emit(Resource.Loading(data = kitsuDao))

        try {
            val remoteResponse = api.getTrendingMangaList().data
            dao.deleteMangaTrendingIdsDao(remoteResponse.map { it.id })
            dao.insertMangaTrendingDao(remoteResponse.map { it.toMangaTrendingEntity() })
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred.", data = kitsuDao))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "No Internet Connection", data = kitsuDao))
        }

        val newKitsuDao = dao.getMangaTrendingDao().map { it.toMangaTrending() }
        emit(Resource.Success(newKitsuDao))
    }

    override fun getMangaList(): Flow<Resource<List<Data>>> = flow {
        emit(Resource.Loading())

        val kitsuDao = dao.getMangaDao().map { it.toManga() }
        emit(Resource.Loading(data = kitsuDao))

        try {
            val remoteResponse = api.getMangaList().data
            dao.deleteMangaIdsDao(remoteResponse.map { it.id })
            dao.insertMangaDao(remoteResponse.map { it.toMangaEntity() })
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred.", data = kitsuDao))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "No Internet Connection", data = kitsuDao))
        }

        val newKitsuDao = dao.getMangaDao().map { it.toManga() }
        emit(Resource.Success(newKitsuDao))
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

    override suspend fun insertMangaTrendingDao(mangaTrendingEntity: List<MangaTrendingEntity>) {
        return dao.insertMangaTrendingDao(mangaTrendingEntity)
    }

    override suspend fun getMangaTrendingDao(): List<MangaTrendingEntity> {
        return dao.getMangaTrendingDao()
    }

    override suspend fun deleteMangaTrendingIdsDao(ids: List<String>) {
        return dao.deleteMangaTrendingIdsDao(ids)
    }

    override suspend fun insertMangaDao(mangaEntity: List<MangaEntity>) {
        return dao.insertMangaDao(mangaEntity)
    }

    override suspend fun getMangaDao(): List<MangaEntity> {
        return dao.getMangaDao()
    }

    override suspend fun deleteMangaIdsDao(ids: List<String>) {
        return dao.deleteMangaIdsDao(ids)
    }

}