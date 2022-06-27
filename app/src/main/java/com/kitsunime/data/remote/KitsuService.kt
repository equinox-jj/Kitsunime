package com.kitsunime.data.remote

import com.kitsunime.data.remote.dto.ResponseDto
import com.kitsunime.presentation.util.Constants.ANIME
import com.kitsunime.presentation.util.Constants.ANIME_TRENDING
import com.kitsunime.presentation.util.Constants.CATEGORIES
import com.kitsunime.presentation.util.Constants.LIMIT
import com.kitsunime.presentation.util.Constants.MANGA
import com.kitsunime.presentation.util.Constants.MANGA_TRENDING
import com.kitsunime.presentation.util.Constants.OFFSET
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