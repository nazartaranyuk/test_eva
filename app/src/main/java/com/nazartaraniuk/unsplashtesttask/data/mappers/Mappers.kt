package com.nazartaraniuk.unsplashtesttask.data.mappers

import com.nazartaraniuk.unsplashtesttask.data.models.UnsplashImageData
import com.nazartaraniuk.unsplashtesttask.domain.models.UnsplashImageDomain

fun UnsplashImageData.toPhotoDomain() : UnsplashImageDomain {
    return UnsplashImageDomain(
        id = this.id,
        urls = this.urls,
        likes = this.likes,
        user = this.user,
        dataOfCreation = this.dataOfCreation
    )
}

fun UnsplashImageDomain.toUnsplashImageData() : UnsplashImageData {
    return UnsplashImageData(
        id = this.id,
        urls = this.urls,
        likes = this.likes,
        user = this.user,
        dataOfCreation = this.dataOfCreation
    )
}