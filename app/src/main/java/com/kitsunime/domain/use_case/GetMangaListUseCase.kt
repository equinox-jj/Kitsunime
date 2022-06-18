package com.kitsunime.domain.use_case

import com.kitsunime.common.Resource
import com.kitsunime.data.remote.model.Data
import com.kitsunime.data.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetMangaListUseCase @Inject constructor(
    private val repository: Repository,
) {

    operator fun invoke(): Flow<Resource<List<Data>>> = flow {

        try {
            emit(Resource.Loading())
            val response = repository.getMangaList().data
            emit(Resource.Success(response))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred."))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage
                ?: "Couldn't reach server. Check your internet connection."))
        }

    }

}