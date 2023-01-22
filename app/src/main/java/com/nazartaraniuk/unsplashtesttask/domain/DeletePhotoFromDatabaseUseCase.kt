package com.nazartaraniuk.unsplashtesttask.domain

import com.nazartaraniuk.unsplashtesttask.domain.models.UnsplashImageDomain
import com.nazartaraniuk.unsplashtesttask.domain.repositories.LocalRepository
import javax.inject.Inject

class DeletePhotoFromDatabaseUseCase @Inject constructor(
    private val localRepository: LocalRepository
) {

    suspend operator fun invoke(photo: UnsplashImageDomain) {
        localRepository.deletePhoto(photo)
    }
}