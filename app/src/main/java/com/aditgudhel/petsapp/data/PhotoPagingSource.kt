package com.aditgudhel.petsapp.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.aditgudhel.petsapp.api.ApiService
import retrofit2.HttpException
import java.io.IOException

private const val STARTING_PAGE = 1

class PhotoPagingSource(
    private val apiService: ApiService,
    private val query: String
) : PagingSource<Int, Photo>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Photo> {
        val position = params.key ?: STARTING_PAGE

        return try {
            val response = apiService.searchPhotos(query, position, params.loadSize)
            val photos = response.results

            LoadResult.Page(
                data = photos,
                prevKey = if (position == STARTING_PAGE) null else position - 1,
                nextKey = if (photos.isEmpty()) null else position + 1
            )
        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Photo>): Int? {
        TODO("Not yet implemented")
    }


}