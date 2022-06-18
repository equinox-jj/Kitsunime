package com.kitsunime.domain.use_case

import com.kitsunime.common.Resource
import com.kitsunime.data.remote.model.Data
import com.kitsunime.domain.repository.IRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAnimeListUseCase @Inject constructor(
    private val repository: IRepository,
) {

    operator fun invoke(): Flow<Resource<List<Data>>> = flow {
        emit(Resource.Loading())

        val kitsuDao = repository.getAnimeDao().map { it.toAnime() }
        emit(Resource.Loading(data = kitsuDao))

        try {
            val remoteResponse = repository.getAnimeList().data
            repository.deleteAnimeIdsDao(remoteResponse.map { it.id })
            repository.insertAnimeDao(remoteResponse.map { it.toAnimeEntity() })
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred.", data = kitsuDao))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "No Internet Connection", data = kitsuDao))
        }

        val newKitsuDao = repository.getAnimeDao().map { it.toAnime() }
        emit(Resource.Success(newKitsuDao))

    }


}