package com.kitsunime.data.remote

import com.kitsunime.common.Constants.ANIME
import com.kitsunime.common.Constants.ANIME_TRENDING
import com.kitsunime.common.Constants.MANGA
import com.kitsunime.common.Constants.MANGA_TRENDING
import com.kitsunime.data.remote.dto.KitsuResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface KitsuService {

    @GET(ANIME_TRENDING)
    suspend fun getTrendingAnimeList(): KitsuResponse

    @GET(ANIME)
    suspend fun getAnimeList(
        @Query("page[offset]") offset: Int = 0,
        @Query("page[limit]") limit: Int = 10,
        @Query("include") categories: String = "categories",
    ): KitsuResponse

    @GET(MANGA_TRENDING)
    suspend fun getTrendingMangaList(): KitsuResponse

    @GET(MANGA)
    suspend fun getMangaList(
        @Query("page[offset]") offset: Int = 0,
        @Query("page[limit]") limit: Int = 10,
        @Query("include") categories: String = "categories",
    ): KitsuResponse
}