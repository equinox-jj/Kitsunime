package com.kitsunime.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.kitsunime.data.local.dao.KitsuDao
import com.kitsunime.data.paging.AnimePagingSource
import com.kitsunime.data.remote.KitsuService
import com.kitsunime.domain.model.KitsuResult
import com.kitsunime.domain.repository.IAnimeRepository
import com.kitsunime.domain.util.Resource
import com.kitsunime.presentation.util.Constants.LIMIT
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AnimeRepository @Inject constructor(
    private val api: KitsuService,
    private val dao: KitsuDao,
) : IAnimeRepository {

    // Remote AnimeRepository
    override fun getAnimeTrendingList(): Flow<Resource<List<KitsuResult>>> = flow {
        emit(Resource.Loading())

        val kitsuDao = dao.getAnimeTrendingDao().map { it.toKitsuResult() }
        emit(Resource.Loading(data = kitsuDao))

        try {
            val remoteResponse = api.getTrendingAnimeList().data
            dao.deleteAnimeTrendingIdsDao(remoteResponse.map { it.id })
            dao.insertAnimeTrendingDao(remoteResponse.map { it.toAnimeTrendingEntity() })
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = e.localizedMessage ?: "An unexpected error occurred.",
                data = kitsuDao
            ))
        } catch (e: IOException) {
            emit(Resource.Error(
                message = e.localizedMessage ?: "No Internet Connection.",
                data = kitsuDao
            ))
        }

        val newKitsuDao = dao.getAnimeTrendingDao().map { it.toKitsuResult() }
        emit(Resource.Success(newKitsuDao))
    }.flowOn(Dispatchers.IO)

    override fun getAnimeList(): Flow<Resource<List<KitsuResult>>> = flow {
        emit(Resource.Loading())

        val kitsuDao = dao.getAnimeDao().map { it.toKitsuResult() }
        emit(Resource.Loading(data = kitsuDao))

        try {
            val remoteResponse = api.getAnimeList().data
            dao.deleteAnimeIdsDao(remoteResponse.map { it.id })
            dao.insertAnimeDao(remoteResponse.map { it.toAnimeEntity() })
        } catch (e: HttpException) {
            emit(Resource.Error(
                message = e.localizedMessage ?: "An unexpected error occurred.",
                data = kitsuDao
            ))
        } catch (e: IOException) {
            emit(Resource.Error(
                message = e.localizedMessage ?: "No Internet Connection",
                data = kitsuDao
            ))
        }

        val newKitsuDao = dao.getAnimeDao().map { it.toKitsuResult() }
        emit(Resource.Success(newKitsuDao))
    }.flowOn(Dispatchers.IO)

    override fun getAnimePagingSource(): Flow<PagingData<KitsuResult>> = Pager(
        config = PagingConfig(enablePlaceholders = false, pageSize = LIMIT),
        pagingSourceFactory = { AnimePagingSource(api) }
    ).flow

}