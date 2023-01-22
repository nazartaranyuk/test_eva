package com.nazartaraniuk.unsplashtesttask.data.api

import com.nazartaraniuk.unsplashtesttask.data.models.UnsplashImageData
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

const val API_KEY = "LuIGgtk5Sz_3phRCyCpk_NeS8E2OhgQANb45yhmT-Zo"

interface UnsplashAPI {

    @Headers("Authorization: Client-ID $API_KEY")
    @GET("/photos")
    suspend fun getAllPhotos(
        @Query("page") page: Int,
        @Query("per_page") per_page: Int,
    ) : List<UnsplashImageData>

    @Headers("Authorization: Client-ID $API_KEY")
    @GET("/search/photos")
    suspend fun searchImages(
        @Query("page") page: Int,
        @Query("per_page") per_page: Int,
    ) : List<UnsplashImageData>
}