package com.nazartaraniuk.unsplashtesttask.domain.repositories

import com.nazartaraniuk.unsplashtesttask.domain.models.UnsplashImageDomain

interface NetworkRepository {

    suspend fun provideListOfPhotos(
        page: Int,
        per_page: Int
    ) : List<UnsplashImageDomain>
}