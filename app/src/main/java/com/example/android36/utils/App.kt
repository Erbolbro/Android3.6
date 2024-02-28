package com.example.android36.utils

import android.app.Application
import androidx.room.Room
import com.example.android36.data.local.AppDatabase

class App : Application() {

    companion object {

        lateinit var db: AppDatabase
            private set
    }

    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "Hello")
            .allowMainThreadQueries().fallbackToDestructiveMigration().build()

    }
}