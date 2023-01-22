package com.nazartaraniuk.unsplashtesttask.domain.repositories

import com.nazartaraniuk.unsplashtesttask.data.models.UnsplashImageData
import com.nazartaraniuk.unsplashtesttask.domain.models.UnsplashImageDomain
import kotlinx.coroutines.flow.Flow

interface LocalRepository {

    suspend fun savePhoto(photo: UnsplashImageDomain)

    suspend fun deletePhoto(photo: UnsplashImageDomain)

    suspend fun getSavedPhotos() : Flow<List<UnsplashImageData>>
}