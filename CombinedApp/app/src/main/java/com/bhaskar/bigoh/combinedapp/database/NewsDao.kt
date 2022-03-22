package com.bhaskar.bigoh.combinedapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.bhaskar.bigoh.combinedapp.models.NewsDataModel


@Dao
interface NewsDao {
    @Insert
    suspend fun downloadNews(newsDataModel: NewsDataModel)

    @Delete
    suspend fun deleteNews(newsDataModel: NewsDataModel)

    @Query("SELECT * FROM news_combine_table")
    fun getNews(): LiveData<List<NewsDataModel>>

    @Query("SELECT * FROM news_combine_table WHERE title = :titleValue")
    fun newsCheck(titleValue: String): NewsDataModel

    @Query("DELETE FROM news_combine_table WHERE id = :id")
    fun deleteSingleNews(id: Long): Unit
}