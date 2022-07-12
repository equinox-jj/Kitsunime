package com.kitsunime.domain.repository

import androidx.paging.PagingData
import com.kitsunime.domain.model.KitsuResult
import com.kitsunime.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface IAnimeRepository {

    fun getAnimeTrendingList(): Flow<Resource<List<KitsuResult>>>
    fun getAnimeList(): Flow<Resource<List<KitsuResult>>>
    fun getAnimePagingSource(): Flow<PagingData<KitsuResult>>

}