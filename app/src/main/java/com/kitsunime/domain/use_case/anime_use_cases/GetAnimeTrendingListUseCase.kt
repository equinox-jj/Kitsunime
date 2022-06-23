package com.kitsunime.domain.use_case.anime_use_cases

import com.kitsunime.common.Resource
import com.kitsunime.data.remote.dto.KitsuResults
import com.kitsunime.domain.repository.IRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAnimeTrendingListUseCase @Inject constructor(
    private val repository: IRepository,
) {

    operator fun invoke(): Flow<Resource<List<KitsuResults>>> {
        return repository.getAnimeTrendingList()
    }

}