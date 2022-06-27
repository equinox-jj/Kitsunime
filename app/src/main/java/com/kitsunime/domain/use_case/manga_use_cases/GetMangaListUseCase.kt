package com.kitsunime.domain.use_case.manga_use_cases

import com.kitsunime.data.repository.Repository
import com.kitsunime.domain.model.KitsuResult
import com.kitsunime.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMangaListUseCase @Inject constructor(private val repository: Repository) {
    operator fun invoke(): Flow<Resource<List<KitsuResult>>> {
        return repository.getMangaList()
    }
}