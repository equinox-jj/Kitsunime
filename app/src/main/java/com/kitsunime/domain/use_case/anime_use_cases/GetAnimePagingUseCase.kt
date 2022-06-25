package com.kitsunime.domain.use_case.anime_use_cases

import androidx.paging.PagingData
import com.kitsunime.data.repository.Repository
import com.kitsunime.domain.model.KitsuResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAnimePagingUseCase @Inject constructor(private val repository: Repository) {
    operator fun invoke(): Flow<PagingData<KitsuResult>> {
        return repository.getAnimePagingSource()
    }
}