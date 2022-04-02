package com.bhaskar.bigoh.combinedapp.interfaces

import com.bhaskar.bigoh.combinedapp.apimodels.NewsModel
import com.bhaskar.bigoh.combinedapp.constants.Constant
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET(Constant.API_ENDPOINT)
    suspend fun getNews(): Response<NewsModel>
}