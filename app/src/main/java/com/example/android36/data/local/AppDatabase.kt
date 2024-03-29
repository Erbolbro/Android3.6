package com.example.android36.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android36.data.local.room.dao.PhotosDao
import com.example.android36.data.remote.models.PhotoResponseItem

@Database(entities = [PhotoResponseItem::class], version = 3)
abstract class AppDatabase : RoomDatabase() {
    abstract fun photosDao(): PhotosDao

    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext, AppDatabase::class.java, "database"
                ).allowMainThreadQueries().fallbackToDestructiveMigration().build()
                INSTANCE = instance
                instance
            }
        }
    }
}