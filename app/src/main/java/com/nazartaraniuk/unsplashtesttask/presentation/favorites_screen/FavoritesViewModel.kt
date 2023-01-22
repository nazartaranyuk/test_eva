package com.nazartaraniuk.unsplashtesttask.presentation.favorites_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nazartaraniuk.unsplashtesttask.domain.DeletePhotoFromDatabaseUseCase
import com.nazartaraniuk.unsplashtesttask.domain.ProvideFavoritesPhotosUseCase
import com.nazartaraniuk.unsplashtesttask.presentation.mappers.toPhotoUI
import com.nazartaraniuk.unsplashtesttask.presentation.mappers.toUnsplashImageDomain
import com.nazartaraniuk.unsplashtesttask.presentation.models.PhotoImageUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

class FavoritesViewModel @Inject constructor(
    private val deletePhotoFromDatabaseUseCase: DeletePhotoFromDatabaseUseCase,
    private val provideFavoritesPhotos: ProvideFavoritesPhotosUseCase
) : ViewModel() {

    private val _stateFlow = MutableStateFlow<List<PhotoImageUI>>(listOf())
    val stateFlow: StateFlow<List<PhotoImageUI>> get() = _stateFlow

    fun deletePhoto(photo: PhotoImageUI) {
        viewModelScope.launch(Dispatchers.IO) {
            deletePhotoFromDatabaseUseCase(photo.toUnsplashImageDomain())
        }
    }

    fun loadPhotos() {
        viewModelScope.launch(Dispatchers.IO) {
            provideFavoritesPhotos().collect { list ->
                _stateFlow.emit(
                    list.map { image ->
                        image.toPhotoUI()
                    }
                )
            }
        }
    }
}