package com.carmedia2p0.capture.data.network.api

import com.carmedia2p0.capture.model.GithubUser
import com.carmedia2p0.capture.model.response.getInventory.GetInventoryResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface CarmediaApi {

    @GET("https://api.github.com/users/jakewharton")
    fun getData(): Flow<GithubUser>

    @GET("/capture/1.0/dealers/capHi-pXFECO2SozmMb5QQ/vehicle-listings")
    suspend fun getInventory(): Response<GetInventoryResponse>

// //   example
//    @GET("/apps/wildfox/locate_store")
//    suspend fun locateZipCode(
//        @Query("zip_code") zipCode: String,
//        @Query("distance") distance: String
//    ): Response<ZipCodeResponse>
}
