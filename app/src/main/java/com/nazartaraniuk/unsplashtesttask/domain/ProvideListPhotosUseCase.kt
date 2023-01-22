package com.nazartaraniuk.unsplashtesttask.domain

import com.nazartaraniuk.unsplashtesttask.domain.models.UnsplashImageDomain
import com.nazartaraniuk.unsplashtesttask.domain.repositories.NetworkRepository
import javax.inject.Inject

class ProvideListPhotosUseCase @Inject constructor(
    private val repository: NetworkRepository
) {

    suspend operator fun invoke(page: Int, per_page: Int) : List<UnsplashImageDomain> {
        return repository.provideListOfPhotos(page, per_page)
    }
}