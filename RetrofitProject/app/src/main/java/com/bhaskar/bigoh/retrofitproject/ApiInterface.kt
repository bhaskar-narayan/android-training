package com.bhaskar.bigoh.retrofitproject

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {
    @GET("v2/everything?q=tesla&from=2022-01-17&sortBy=publishedAt&apiKey=d84a24a07e61440889b899c2c3f61035")
    fun getData() : Call<Data>

    companion object {

        private var BASE_URL = "https://newsapi.org/"

        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}