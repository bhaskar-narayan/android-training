package com.bhaskar.bigoh.newsappproject.clients

import com.bhaskar.bigoh.newsappproject.interfaces.HomeApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class HomeApiClient {
    companion object {
        private var BASE_URL = "https://newsapi.org/"
        fun create() : HomeApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(HomeApiInterface::class.java)
        }
    }
}