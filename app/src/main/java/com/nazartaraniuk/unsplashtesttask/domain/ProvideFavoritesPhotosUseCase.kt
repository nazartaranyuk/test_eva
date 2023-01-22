package com.nazartaraniuk.unsplashtesttask.domain

import com.nazartaraniuk.unsplashtesttask.data.mappers.toPhotoDomain
import com.nazartaraniuk.unsplashtesttask.domain.models.UnsplashImageDomain
import com.nazartaraniuk.unsplashtesttask.domain.repositories.LocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ProvideFavoritesPhotosUseCase @Inject constructor(
    private val repository: LocalRepository
) {

    suspend operator fun invoke() : Flow<List<UnsplashImageDomain>> {
        return repository.getSavedPhotos().map { list ->
            list.map { image ->
                image.toPhotoDomain()
            }
        }
    }
}