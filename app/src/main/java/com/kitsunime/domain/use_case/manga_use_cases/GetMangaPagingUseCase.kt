package com.kitsunime.domain.use_case.manga_use_cases

import androidx.paging.PagingData
import com.kitsunime.data.repository.MangaRepository
import com.kitsunime.domain.model.KitsuResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMangaPagingUseCase @Inject constructor(private val mangaRepository: MangaRepository) {
    operator fun invoke(): Flow<PagingData<KitsuResult>> {
        return mangaRepository.getMangaPagingSource()
    }
}