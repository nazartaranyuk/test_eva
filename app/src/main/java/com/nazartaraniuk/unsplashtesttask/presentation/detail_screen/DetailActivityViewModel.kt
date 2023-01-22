package com.nazartaraniuk.unsplashtesttask.presentation.detail_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nazartaraniuk.unsplashtesttask.domain.SavePhotoUseCase
import com.nazartaraniuk.unsplashtesttask.domain.repositories.LocalRepository
import com.nazartaraniuk.unsplashtesttask.presentation.mappers.toUnsplashImageDomain
import com.nazartaraniuk.unsplashtesttask.presentation.models.PhotoImageUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailActivityViewModel @Inject constructor(
    private val savePhotoUseCase: SavePhotoUseCase
) : ViewModel() {


    fun saveImage(image: PhotoImageUI) {
        viewModelScope.launch(Dispatchers.IO) {
            savePhotoUseCase(image.toUnsplashImageDomain())
        }
    }
}