package com.nazartaraniuk.unsplashtesttask.data.models

import com.squareup.moshi.Json

data class SearchResult(
    @Json(name = "results")
    val images: List<UnsplashImageData>
)