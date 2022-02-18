package com.bhaskar.bigoh.newsappproject.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "news_table")
data class Download (
        @PrimaryKey(autoGenerate = true)
        val id : Long,
        val title : String,
        val author : String,
        val publish : String,
        val description : String,
        val content : String,
        val image : String
        )