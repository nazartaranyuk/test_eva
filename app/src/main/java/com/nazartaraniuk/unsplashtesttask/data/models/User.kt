package com.nazartaraniuk.unsplashtesttask.data.models

import android.os.Parcelable
import androidx.room.Embedded
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    @Json(name = "links")
    @Embedded
    val userLinks: UserLinks,
    val username: String,
    @Json(name = "profile_image")
    @Embedded
    val userAvatar: ProfileImage
) : Parcelable