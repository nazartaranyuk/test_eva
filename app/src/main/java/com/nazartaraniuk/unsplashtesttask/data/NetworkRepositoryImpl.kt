package com.nazartaraniuk.unsplashtesttask.data

import com.nazartaraniuk.unsplashtesttask.data.api.UnsplashAPI
import com.nazartaraniuk.unsplashtesttask.data.mappers.toPhotoDomain
import com.nazartaraniuk.unsplashtesttask.domain.models.UnsplashImageDomain
import com.nazartaraniuk.unsplashtesttask.domain.repositories.NetworkRepository
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(
    private val api: UnsplashAPI
) : NetworkRepository {

    override suspend fun provideListOfPhotos(
        page: Int,
        per_page: Int
    ): List<UnsplashImageDomain> {
        return api.getAllPhotos(page, per_page).map { image ->
            image.toPhotoDomain()
        }
    }

}