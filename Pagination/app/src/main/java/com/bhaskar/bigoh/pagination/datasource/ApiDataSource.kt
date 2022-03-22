package com.bhaskar.bigoh.pagination.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bhaskar.bigoh.pagination.interfaces.ApiInterface
import com.bhaskar.bigoh.pagination.models.Hit
import java.lang.Exception

class ApiDataSource(private val apiInterface: ApiInterface) : PagingSource<Int, Hit>() {
    override fun getRefreshKey(state: PagingState<Int, Hit>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Hit> {
        try {
            val currentNewsList = params.key ?: 1
            val response = apiInterface.getPhotos(currentNewsList)
            val responseList = mutableListOf<Hit>()
            val data = response.body()?.hits ?: emptyList()
            responseList.addAll(data)
            val prevKey = if (currentNewsList == 1) null else currentNewsList - 1

            return LoadResult.Page(
                responseList,
                prevKey,
                currentNewsList.plus(1)
            )

        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }
}