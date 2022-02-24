package com.bhaskar.bigoh.newsappproject.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface DownloadDao {
    @Insert
    suspend fun downloadNews(download: Download)

    @Delete
    suspend fun deleteNews(download: Download)

    @Query ("SELECT * FROM news_table")
    fun getNews() : LiveData<List<Download>>
    @Query ("SELECT * FROM news_table WHERE title = :titleValue")
    fun newsCheck(titleValue : String) : Download
}