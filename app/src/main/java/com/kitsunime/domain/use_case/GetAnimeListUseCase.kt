package com.kitsunime.domain.use_case

import com.kitsunime.common.Resource
import com.kitsunime.data.remote.model.AnimeListResponse
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

        try {
            emit(Resource.Loading())
            val response = repository.getAnimeList().data
            emit(Resource.Success((response)))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage
                ?: "Couldn't reach server. Check your internet connection."))
        }

    }


}