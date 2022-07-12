package com.kitsunime.domain.repository

import androidx.paging.PagingData
import com.kitsunime.domain.model.KitsuResult
import com.kitsunime.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface IMangaRepository {

    fun getMangaTrendingList(): Flow<Resource<List<KitsuResult>>>
    fun getMangaList(): Flow<Resource<List<KitsuResult>>>
    fun getMangaPagingSource(): Flow<PagingData<KitsuResult>>

}