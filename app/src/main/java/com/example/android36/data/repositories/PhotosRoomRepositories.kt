package com.example.android36.data.repositories

import com.example.android36.data.remote.models.PhotoResponseItem
import com.example.android36.utils.App

class PhotosRoomRepositories {

    fun addPhotos(photoResponseItem: PhotoResponseItem) {
        App.db.photosDao().insertAll(photoResponseItem)
    }

    fun getPhotos() = App.db.photosDao().getAll()

    fun editPhoto(photoResponseItem: PhotoResponseItem) {
        return App.db.photosDao().editPhoto(photoResponseItem)
    }

    fun deletePhoto(photoResponseItem: PhotoResponseItem) {
        return App.db.photosDao().deletePhoto(photoResponseItem)
    }
}