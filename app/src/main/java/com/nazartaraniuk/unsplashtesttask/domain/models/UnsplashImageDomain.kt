package com.nazartaraniuk.unsplashtesttask.domain.models

import com.nazartaraniuk.unsplashtesttask.data.models.Urls
import com.nazartaraniuk.unsplashtesttask.data.models.User

data class UnsplashImageDomain(
    val id: String,
    val dataOfCreation: String,
    val urls: Urls,
    val likes: Int,
    val user: User
)
