package com.example.android36.data.local.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.android36.data.remote.models.PhotoResponseItem

@Dao
interface PhotosDao {

    @Query("SELECT * FROM photoresponseitem")
    fun getAll(): LiveData<MutableList<PhotoResponseItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(photoResponseItem: PhotoResponseItem)

    @Update(PhotoResponseItem::class, onConflict = OnConflictStrategy.REPLACE)
    fun editPhoto(photoResponseItem: PhotoResponseItem)

    @Delete(PhotoResponseItem::class)
    fun deletePhoto(photoResponseItem: PhotoResponseItem)
}