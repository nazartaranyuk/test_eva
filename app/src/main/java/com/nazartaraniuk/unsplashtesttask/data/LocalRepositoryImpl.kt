package com.nazartaraniuk.unsplashtesttask.data

import com.nazartaraniuk.unsplashtesttask.data.dao.LocalPhotosDAO
import com.nazartaraniuk.unsplashtesttask.data.mappers.toUnsplashImageData
import com.nazartaraniuk.unsplashtesttask.data.models.UnsplashImageData
import com.nazartaraniuk.unsplashtesttask.domain.models.UnsplashImageDomain
import com.nazartaraniuk.unsplashtesttask.domain.repositories.LocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val dao: LocalPhotosDAO
) : LocalRepository {

    override suspend fun getSavedPhotos(): Flow<List<UnsplashImageData>> {
        return dao.getPhotos()
    }

    override suspend fun savePhoto(photo: UnsplashImageDomain) {
        dao.insertPhoto(photo.toUnsplashImageData())
    }

    override suspend fun deletePhoto(photo: UnsplashImageDomain) {
        dao.deletePhoto(photo.toUnsplashImageData())
    }
}