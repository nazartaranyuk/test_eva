package com.nazartaraniuk.unsplashtesttask.data.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserLinks(
    val html: String,
) : Parcelable