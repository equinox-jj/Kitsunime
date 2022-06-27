package com.kitsunime.data.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.kitsunime.data.remote.KitsuService
import com.kitsunime.domain.model.KitsuResult
import com.kitsunime.presentation.util.Constants.CATEGORIES
import com.kitsunime.presentation.util.Constants.LIMIT
import com.kitsunime.presentation.util.Constants.OFFSET
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class AnimePagingSource @Inject constructor(
    private val api: KitsuService,
) : PagingSource<Int, KitsuResult>() {
    override fun getRefreshKey(state: PagingState<Int, KitsuResult>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, KitsuResult> {
        return try {
            val animeOffset = params.key ?: OFFSET

            val response = api.getAnimeList(animeOffset, LIMIT, CATEGORIES)
            val animeResponse = response.toKitsuResponses().data

            val prevKey = if(animeOffset == OFFSET) null else animeOffset - LIMIT
            val nextKey = if(animeResponse.size < 10 || animeResponse.isEmpty()) null else animeOffset + LIMIT

            LoadResult.Page(
                data = animeResponse,
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }
}