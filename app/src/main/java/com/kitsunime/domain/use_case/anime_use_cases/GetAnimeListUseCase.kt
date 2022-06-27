package com.kitsunime.domain.use_case.anime_use_cases

import com.kitsunime.domain.model.KitsuResult
import com.kitsunime.domain.repository.IRepository
import com.kitsunime.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAnimeListUseCase @Inject constructor(private val repository: IRepository) {
    operator fun invoke(): Flow<Resource<List<KitsuResult>>> {
        return repository.getAnimeList()
    }
}