package com.bhaskar.bigoh.combinedapp.client

import com.bhaskar.bigoh.combinedapp.constants.Constant
import com.bhaskar.bigoh.combinedapp.interfaces.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {
        fun create(): ApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(Constant.BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)
        }
    }
}