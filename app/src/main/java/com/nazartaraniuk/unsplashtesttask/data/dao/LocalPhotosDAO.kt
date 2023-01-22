package com.nazartaraniuk.unsplashtesttask.data.dao

import androidx.room.*
import com.nazartaraniuk.unsplashtesttask.data.models.UnsplashImageData
import kotlinx.coroutines.flow.Flow

@Dao
interface LocalPhotosDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhoto(model: UnsplashImageData)

    @Query("SELECT * FROM unsplash_photos")
    fun getPhotos() : Flow<List<UnsplashImageData>>

    @Delete
    fun deletePhoto(photo: UnsplashImageData)
}