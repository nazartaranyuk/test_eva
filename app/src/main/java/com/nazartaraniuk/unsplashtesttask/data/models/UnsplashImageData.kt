package com.nazartaraniuk.unsplashtesttask.data.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

@Entity(tableName = "unsplash_photos")
data class UnsplashImageData(
    @PrimaryKey(autoGenerate = false)
    val id: String,
    @Json(name = "created_at")
    val dataOfCreation: String,
    @Embedded
    val urls: Urls,
    val likes: Int,
    @Embedded
    val user: User
)
