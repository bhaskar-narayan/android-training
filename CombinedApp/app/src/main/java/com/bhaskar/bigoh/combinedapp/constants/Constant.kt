package com.bhaskar.bigoh.combinedapp.constants

object Constant {
    const val BASE_URL: String = "https://newsapi.org/"
    const val DATABASE_NAME: String = "newsCombineDB"
    const val API_ENDPOINT: String =
        "v2/top-headlines?sources=techcrunch&apiKey=d84a24a07e61440889b899c2c3f61035"
    const val DB_TABLE_NAME: String = "news_combine_table"
    const val SHARED_CREDENTIAL: String = "bhaskar-credential-combine"
    const val CHANNEL_ID: String = "Foreground Service"
    const val STARTING_INDEX: Int = 1
    const val SOURCES: String = "techcrunch"
    const val API_KEY: String = "d84a24a07e61440889b899c2c3f61035"
    const val PAGE_SIZE: Int = 20
    const val PREFETCH_DISTANCE: Int = 5
}