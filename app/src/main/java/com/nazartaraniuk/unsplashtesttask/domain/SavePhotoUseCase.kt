package com.nazartaraniuk.unsplashtesttask.domain

import com.nazartaraniuk.unsplashtesttask.domain.models.UnsplashImageDomain
import com.nazartaraniuk.unsplashtesttask.domain.repositories.LocalRepository
import javax.inject.Inject

class SavePhotoUseCase @Inject constructor(
    private val repository: LocalRepository
) {

    suspend operator fun invoke(photo: UnsplashImageDomain) {
        repository.savePhoto(photo)
    }
}