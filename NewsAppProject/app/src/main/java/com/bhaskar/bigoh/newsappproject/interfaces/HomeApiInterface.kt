package com.bhaskar.bigoh.newsappproject.interfaces

import android.telecom.Call
import com.bhaskar.bigoh.newsappproject.homemodel.HomeData
import retrofit2.http.GET

interface HomeApiInterface {
    @GET("v2/everything?q=apple&from=2022-02-17&to=2022-02-17&sortBy=popularity&apiKey=d84a24a07e61440889b899c2c3f61035")
    fun getData() : retrofit2.Call<HomeData>
}


//  v2/everything?q=apple&from=2022-02-16&to=2022-02-16&sortBy=popularity&apiKey=d84a24a07e61440889b899c2c3f61035