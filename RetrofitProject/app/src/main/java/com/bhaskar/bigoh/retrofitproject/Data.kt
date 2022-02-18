package com.bhaskar.bigoh.retrofitproject

import com.google.gson.annotations.SerializedName


data class Data (

  @SerializedName("status"       ) var status       : String?             = null,
  @SerializedName("totalResults" ) var totalResults : Int?                = null,
  @SerializedName("articles"     ) var articles     : ArrayList<Articles> = arrayListOf()

)