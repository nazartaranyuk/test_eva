package com.nazartaraniuk.unsplashtesttask.presentation.di

import com.nazartaraniuk.unsplashtesttask.data.api.UnsplashAPI
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

@Module
class NetworkModule {

    @Provides
    fun provideMoshi(): Moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    @Provides
    fun provideMoshiConverterFactory(moshi: Moshi) : MoshiConverterFactory {
        return MoshiConverterFactory.create(moshi)
    }

    @Provides
    fun provideRetrofit(moshiFactory: MoshiConverterFactory): UnsplashAPI {
        val retrofit =  Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(moshiFactory)
            .build()
        return retrofit.create()
    }

    companion object {
        private const val BASE_URL = "https://api.unsplash.com/"
    }
}
