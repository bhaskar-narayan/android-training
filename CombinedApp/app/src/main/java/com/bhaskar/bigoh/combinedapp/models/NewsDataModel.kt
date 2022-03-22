package com.bhaskar.bigoh.combinedapp.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bhaskar.bigoh.combinedapp.constants.Constant

@Entity(tableName = Constant.DB_TABLE_NAME)
data class NewsDataModel(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val title: String,
    val author: String,
    val publish: String,
    val description: String,
    val content: String,
    val image: String
)
