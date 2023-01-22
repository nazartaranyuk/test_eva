package com.nazartaraniuk.unsplashtesttask.presentation.main_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.nazartaraniuk.unsplashtesttask.domain.ProvideListPhotosUseCase
import com.nazartaraniuk.unsplashtesttask.domain.SavePhotoUseCase
import com.nazartaraniuk.unsplashtesttask.domain.repositories.NetworkRepository
import com.nazartaraniuk.unsplashtesttask.presentation.mappers.toPhotoUI
import com.nazartaraniuk.unsplashtesttask.presentation.mappers.toUnsplashImageDomain
import com.nazartaraniuk.unsplashtesttask.presentation.models.PhotoImageUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeActivityViewModel @Inject constructor(
    private val provideListPhotosUseCase: ProvideListPhotosUseCase,
    private val savePhotoUseCase: SavePhotoUseCase
) : ViewModel() {

    private val _stateFlow = MutableStateFlow<List<PhotoImageUI>>(listOf())
    val stateFlow: StateFlow<List<PhotoImageUI>> get() = _stateFlow

    fun savePhoto(model: PhotoImageUI) = viewModelScope.launch(Dispatchers.IO) {
        savePhotoUseCase(model.toUnsplashImageDomain())
    }

    fun loadPhotos() = viewModelScope.launch(Dispatchers.IO) {

        // TODO MAGIC NUMBERS!!
        _stateFlow.emit(
            provideListPhotosUseCase(1, 10).map { photoDomain ->
                Log.d("Photos", "Photo ${photoDomain.toString()}" )
                photoDomain.toPhotoUI()
            }
        )

    }
}