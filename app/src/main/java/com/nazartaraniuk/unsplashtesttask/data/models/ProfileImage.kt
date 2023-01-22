package com.nazartaraniuk.unsplashtesttask.data.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProfileImage(
    @Json(name = "small")
    val smallImage: String,
    @Json(name = "medium")
    val mediumImage: String,
    @Json(name = "large")
    val largeImage: String,
) : Parcelable
