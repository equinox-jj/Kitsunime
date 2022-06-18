package com.kitsunime.domain.use_case

import com.kitsunime.common.Resource
import com.kitsunime.data.remote.model.Data
import com.kitsunime.domain.repository.IRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAnimeTrendingListUseCase @Inject constructor(
    private val repository: IRepository,
) {

    operator fun invoke(): Flow<Resource<List<Data>>> = flow {
        emit(Resource.Loading())

        // Read The Current Data from Database
        val kitsuDao = repository.getAnimeTrendingDao().map { it.toAnimeTrending() }
        emit(Resource.Loading(data = kitsuDao))

        try {
            val remoteResponse = repository.getAnimeTrendingList().data // Initiate Api Call
            repository.deleteAnimeTrendingIdsDao(remoteResponse.map { it.id }) // Delete The Anime Data From ROOM
            repository.insertAnimeTrendingDao(remoteResponse.map { it.toAnimeTrendingEntity() }) // Replace With New Anime Data
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "An unexpected error occurred.", data = kitsuDao))
        } catch (e: IOException) {
            emit(Resource.Error(message = e.localizedMessage ?: "No Internet Connection.", data = kitsuDao))
        }

        // Emit The Data To UI Layer
        val newKitsuDao = repository.getAnimeTrendingDao().map { it.toAnimeTrending() }
        emit(Resource.Success(newKitsuDao))

    }

}