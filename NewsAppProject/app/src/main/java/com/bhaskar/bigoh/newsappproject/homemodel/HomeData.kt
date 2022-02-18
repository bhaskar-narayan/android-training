package com.bhaskar.bigoh.newsappproject.homemodel

import com.google.gson.annotations.SerializedName


data class HomeData (

  @SerializedName("status"       ) var status       : String?             = null,
  @SerializedName("totalResults" ) var totalResults : Int?                = null,
  @SerializedName("articles"     ) var articles     : ArrayList<Articles> = arrayListOf()

)