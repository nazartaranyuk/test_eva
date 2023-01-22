package com.nazartaraniuk.unsplashtesttask.presentation.models

import android.os.Parcelable
import com.nazartaraniuk.unsplashtesttask.data.models.Urls
import com.nazartaraniuk.unsplashtesttask.data.models.User
import kotlinx.parcelize.Parcelize

@Parcelize
data class PhotoImageUI(
    val id: String,
    val dataOfCreation: String,
    val urls: Urls,
    val likes: Int,
    val user: User
) : Parcelable
