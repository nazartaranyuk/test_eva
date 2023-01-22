package com.nazartaraniuk.unsplashtesttask.presentation.di

import android.app.Application
import com.nazartaraniuk.unsplashtesttask.presentation.favorites_screen.FavoritesActivity
import com.nazartaraniuk.unsplashtesttask.presentation.main_screen.HomeActivity
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        BindModule::class,
        NetworkModule::class,
        RoomModule::class,
        ViewModelModule::class,
        AppModule::class
    ]
)
interface AppComponent {

    fun inject(activity: HomeActivity)
    fun inject(activity: FavoritesActivity)

    @Component.Builder
    interface ComponentBuilder {

        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): ComponentBuilder
    }


}