package com.bhaskar.bigoh.combinedapp.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface NewsDao {
    @Insert
    suspend fun downloadNews(model: Model)

    @Delete
    suspend fun deleteNews(model: Model)

    @Query("SELECT * FROM news_combine_table")
    fun getNews() : LiveData<List<Model>>

    @Query("SELECT * FROM news_combine_table WHERE title = :titleValue")
    fun newsCheck(titleValue : String) : Model
}