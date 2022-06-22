package com.kitsunime.domain.repository

import com.kitsunime.common.Resource
import com.kitsunime.data.remote.dto.KitsuResults
import kotlinx.coroutines.flow.Flow

interface IRepository {

    fun getAnimeTrendingList(): Flow<Resource<List<KitsuResults>>>
    fun getAnimeList(): Flow<Resource<List<KitsuResults>>>

    fun getMangaTrendingList(): Flow<Resource<List<KitsuResults>>>
    fun getMangaList(): Flow<Resource<List<KitsuResults>>>

}