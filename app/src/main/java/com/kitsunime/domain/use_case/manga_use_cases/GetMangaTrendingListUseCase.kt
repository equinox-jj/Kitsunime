package com.kitsunime.domain.use_case.manga_use_cases

import com.kitsunime.common.Resource
import com.kitsunime.data.remote.dto.KitsuResults
import com.kitsunime.data.repository.Repository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMangaTrendingListUseCase @Inject constructor(
    private val repository: Repository,
) {

    operator fun invoke(): Flow<Resource<List<KitsuResults>>> {
        return repository.getMangaTrendingList()
    }

}