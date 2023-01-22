package com.nazartaraniuk.unsplashtesttask.presentation.di

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule {

    @Provides
    fun provideContext(context: Application): Context = context

}