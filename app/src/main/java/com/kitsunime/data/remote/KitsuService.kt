package com.kitsunime.data.remote

import com.kitsunime.common.Constants.ANIME
import com.kitsunime.common.Constants.ANIME_TRENDING
import com.kitsunime.common.Constants.CATEGORIES
import com.kitsunime.common.Constants.LIMIT
import com.kitsunime.common.Constants.MANGA
import com.kitsunime.common.Constants.MANGA_TRENDING
import com.kitsunime.common.Constants.OFFSET
import com.kitsunime.data.remote.dto.ResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface KitsuService {

    @GET(ANIME_TRENDING)
    suspend fun getTrendingAnimeList(): ResponseDto

    @GET(ANIME)
    suspend fun getAnimeList(
        @Query("page[offset]") offset: Int = OFFSET,
        @Query("page[limit]") limit: Int = LIMIT,
        @Query("include") categories: String = CATEGORIES,
    ): ResponseDto

    @GET(MANGA_TRENDING)
    suspend fun getTrendingMangaList(): ResponseDto

    @GET(MANGA)
    suspend fun getMangaList(
        @Query("page[offset]") offset: Int = OFFSET,
        @Query("page[limit]") limit: Int = LIMIT,
        @Query("include") categories: String = CATEGORIES,
    ): ResponseDto
}