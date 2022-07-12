package com.kitsunime.data.repository

import androidx.paging.PagingData
import com.kitsunime.data.local.dao.KitsuDao
import com.kitsunime.data.remote.KitsuService
import com.kitsunime.domain.model.KitsuResult
import com.kitsunime.domain.repository.IMangaRepository
import com.kitsunime.domain.util.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class MangaRepository @Inject constructor(
    private val api: KitsuService,
    private val dao: KitsuDao,
) : IMangaRepository {

    // Remote AnimeRepository
    override fun getMangaTrendingList(): Flow<Resource<List<KitsuResult>>> = flow {
        emit(Resource.Loading())

        val kitsuDao = dao.getMangaTrendingDao().map { it.toKitsuResult() }
        emit(Resource.Loading(data = kitsuDao))

        try {
            val remoteResponse = api.getTrendingMangaList().data
            dao.deleteMangaTrendingIdsDao(remoteResponse.map { it.id })
            dao.insertMangaTrendingDao(remoteResponse.map { it.toMangaTrendingEntity() })
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

        val newKitsuDao = dao.getMangaTrendingDao().map { it.toKitsuResult() }
        emit(Resource.Success(newKitsuDao))
    }.flowOn(Dispatchers.IO)

    override fun getMangaList(): Flow<Resource<List<KitsuResult>>> = flow {
        emit(Resource.Loading())

        val kitsuDao = dao.getMangaDao().map { it.toKitsuResult() }
        emit(Resource.Loading(data = kitsuDao))

        try {
            val remoteResponse = api.getMangaList().data
            dao.deleteMangaIdsDao(remoteResponse.map { it.id })
            dao.insertMangaDao(remoteResponse.map { it.toMangaEntity() })
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

        val newKitsuDao = dao.getMangaDao().map { it.toKitsuResult() }
        emit(Resource.Success(newKitsuDao))
    }.flowOn(Dispatchers.IO)

    override fun getMangaPagingSource(): Flow<PagingData<KitsuResult>> {
        return flow { }
    }

}