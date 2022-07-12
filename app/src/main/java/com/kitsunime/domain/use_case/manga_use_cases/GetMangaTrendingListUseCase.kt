package com.kitsunime.domain.use_case.manga_use_cases

import com.kitsunime.data.repository.MangaRepository
import com.kitsunime.domain.model.KitsuResult
import com.kitsunime.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMangaTrendingListUseCase @Inject constructor(private val mangaRepository: MangaRepository) {
    operator fun invoke(): Flow<Resource<List<KitsuResult>>> {
        return mangaRepository.getMangaTrendingList()
    }
}