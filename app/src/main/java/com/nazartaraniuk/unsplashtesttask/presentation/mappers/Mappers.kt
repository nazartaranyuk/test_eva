package com.nazartaraniuk.unsplashtesttask.presentation.mappers

import com.nazartaraniuk.unsplashtesttask.domain.models.UnsplashImageDomain
import com.nazartaraniuk.unsplashtesttask.presentation.models.PhotoImageUI

fun UnsplashImageDomain.toPhotoUI() : PhotoImageUI {
    return PhotoImageUI(
        id = this.id,
        urls = this.urls,
        likes = this.likes,
        user = this.user,
        dataOfCreation = this.dataOfCreation
    )
}

fun PhotoImageUI.toUnsplashImageDomain() : UnsplashImageDomain {
    return UnsplashImageDomain(
        id = this.id,
        urls = this.urls,
        likes = this.likes,
        user = this.user,
        dataOfCreation = this.dataOfCreation
    )
}