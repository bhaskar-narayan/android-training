package com.bhaskar.bigoh.combinedapp.interfaces

import androidx.lifecycle.LiveData
import com.bhaskar.bigoh.combinedapp.apimodels.Articles
import com.bhaskar.bigoh.combinedapp.apimodels.NewsModel
import com.bhaskar.bigoh.combinedapp.constants.Constant
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {
    @GET(Constant.API_ENDPOINT)
    suspend fun getNews(): Response<NewsModel>
}