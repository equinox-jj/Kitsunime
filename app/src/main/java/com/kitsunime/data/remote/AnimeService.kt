package com.kitsunime.data.remote

import com.kitsunime.domain.model.animelist.AnimeListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AnimeService {

    @GET("trending/anime")
    suspend fun getTrendingAnimeList(): AnimeListResponse

    @GET("anime")
    suspend fun getAnimeList(
        @Query("page[offset]") offset: Int = 0,
        @Query("page[limit]") limit: Int = 10,
        @Query("include") categories: String = "categories",
    ): AnimeListResponse

}