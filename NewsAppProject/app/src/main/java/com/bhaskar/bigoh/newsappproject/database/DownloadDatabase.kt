package com.bhaskar.bigoh.newsappproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bhaskar.bigoh.newsappproject.adapters.HomeRecyclerAdapter
import com.bhaskar.bigoh.newsappproject.fragments.DownloadScreen
import com.bhaskar.bigoh.newsappproject.fragments.HomeScreen

@Database(entities = [Download::class], version = 1)
abstract class DownloadDatabase : RoomDatabase() {
    abstract fun downloadDao(): DownloadDao

    companion object {
        @Volatile
        private var INSTANCE: DownloadDatabase? = null
        fun getDatabase(context: Context): DownloadDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room
                        .databaseBuilder(
                            context.applicationContext,
                            DownloadDatabase::class.java,
                            "newsDB"
                        )
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}