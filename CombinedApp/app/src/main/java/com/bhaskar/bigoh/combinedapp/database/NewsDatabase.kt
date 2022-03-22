package com.bhaskar.bigoh.combinedapp.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bhaskar.bigoh.combinedapp.constants.Constant
import com.bhaskar.bigoh.combinedapp.models.NewsDataModel

@Database(entities = [NewsDataModel::class], version = 1)
abstract class NewsDatabase : RoomDatabase() {
    abstract fun newsDao(): NewsDao

    companion object {
        @Volatile
        private var INSTANCE: NewsDatabase? = null
        fun getDatabase(context: Context): NewsDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room
                        .databaseBuilder(
                            context.applicationContext,
                            NewsDatabase::class.java,
                            Constant.DATABASE_NAME
                        )
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}