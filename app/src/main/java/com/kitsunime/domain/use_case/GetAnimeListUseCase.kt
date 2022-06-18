package com.kitsunime.domain.use_case

import com.kitsunime.common.Resource
import com.kitsunime.data.remote.model.Data
import com.kitsunime.domain.repository.IRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAnimeListUseCase @Inject constructor(
    private val repository: IRepository,
) {

    operator fun invoke(): Flow<Resource<List<Data>>> {
        return repository.getAnimeList()
    }

}