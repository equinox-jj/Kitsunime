package com.kitsunime.domain.repository

import androidx.paging.PagingData
import com.kitsunime.common.Resource
import com.kitsunime.domain.model.KitsuResult
import kotlinx.coroutines.flow.Flow

interface IRepository {

    fun getAnimeTrendingList(): Flow<Resource<List<KitsuResult>>>
    fun getAnimeList(): Flow<Resource<List<KitsuResult>>>

    fun getMangaTrendingList(): Flow<Resource<List<KitsuResult>>>
    fun getMangaList(): Flow<Resource<List<KitsuResult>>>

    fun getAnimePagingSource(): Flow<PagingData<KitsuResult>>
    fun getMangaPagingSource(): Flow<PagingData<KitsuResult>>

}