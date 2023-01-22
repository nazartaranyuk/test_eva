package com.nazartaraniuk.unsplashtesttask.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nazartaraniuk.unsplashtesttask.data.dao.LocalPhotosDAO
import com.nazartaraniuk.unsplashtesttask.data.models.UnsplashImageData

@Database(entities = [UnsplashImageData::class], version = 1, exportSchema = false)
abstract class LocalDatabase : RoomDatabase() {

    abstract fun getPhotosDatabase(): LocalPhotosDAO
}