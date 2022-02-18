package com.bhaskar.bigoh.roomproject.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.bhaskar.bigoh.roomproject.Converter

@Database(entities = [Contact::class], version = 1)
@TypeConverters(Converter::class)
abstract class ContactDatabase : RoomDatabase() {
    abstract fun contactDao() : ContactDao

    companion object {
        @Volatile
        private var INSTANCE : ContactDatabase? = null
        fun getDatabase(context: Context) : ContactDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room
                        .databaseBuilder(context.applicationContext, ContactDatabase::class.java, "contactDB")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}