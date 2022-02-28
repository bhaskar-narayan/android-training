package com.bhaskar.bigoh.combinedapp.interfaces

import com.bhaskar.bigoh.combinedapp.apimodels.NewsModel
import retrofit2.http.GET

interface ApiInterface {
    @GET("v2/top-headlines?sources=techcrunch&apiKey=d84a24a07e61440889b899c2c3f61035")
    fun getNews() : retrofit2.Call<NewsModel>
}