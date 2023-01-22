package com.nazartaraniuk.unsplashtesttask.presentation.di

import android.content.Context
import androidx.room.Room
import com.nazartaraniuk.unsplashtesttask.data.LocalDatabase
import com.nazartaraniuk.unsplashtesttask.data.dao.LocalPhotosDAO
import dagger.Module
import dagger.Provides

@Module
class RoomModule {

    @Provides
    fun provideDao(roomDatabase: LocalDatabase): LocalPhotosDAO = roomDatabase.getPhotosDatabase()

    @Provides
    fun provideDatabase(context: Context): LocalDatabase = Room.databaseBuilder(
        context,
        LocalDatabase::class.java,
        LocalDatabase::class.simpleName
    ).build()

}