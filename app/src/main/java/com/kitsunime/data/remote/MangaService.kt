package com.kitsunime.data.remote

import com.kitsunime.data.remote.model.AnimeListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MangaService {

    @GET("trending/anime")
    suspend fun getTrendingMangaList(): AnimeListResponse

    @GET("anime")
    suspend fun getMangaList(
        @Query("page[offset]") offset: Int = 0,
        @Query("page[limit]") limit: Int = 10,
        @Query("include") categories: String = "categories",
    ): AnimeListResponse

}