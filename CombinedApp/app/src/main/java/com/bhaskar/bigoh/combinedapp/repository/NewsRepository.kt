package com.bhaskar.bigoh.combinedapp.repository

import com.bhaskar.bigoh.combinedapp.apimodels.NewsModel
import com.bhaskar.bigoh.combinedapp.client.ApiClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

class NewsRepository {

    companion object {
        fun getData(): Flow<Response<NewsModel>> = flow {
            val response = ApiClient.create().getNews()
            emit(response)
        }.flowOn(Dispatchers.IO)
    }

}