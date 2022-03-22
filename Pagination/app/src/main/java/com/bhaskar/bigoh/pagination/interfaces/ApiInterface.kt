package com.bhaskar.bigoh.pagination.interfaces

import com.bhaskar.bigoh.pagination.constants.Constant
import com.bhaskar.bigoh.pagination.models.PhotoModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET (Constant.API_ENDPOINT)
    suspend fun getPhotos(
        @Query("page") page: Int,
        @Query("key") key: String = Constant.API_KEY
    ): Response<PhotoModel>

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