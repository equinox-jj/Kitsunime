package com.kitsunime.domain.use_case.manga_use_cases

import androidx.paging.PagingData
import com.kitsunime.data.repository.Repository
import com.kitsunime.domain.model.KitsuResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMangaPagingUseCase @Inject constructor(private val repository: Repository) {
    operator fun invoke(): Flow<PagingData<KitsuResult>> {
        return repository.getMangaPagingSource()
    }
}