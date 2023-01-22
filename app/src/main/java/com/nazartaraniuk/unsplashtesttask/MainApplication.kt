package com.nazartaraniuk.unsplashtesttask

import android.app.Application
import com.nazartaraniuk.unsplashtesttask.presentation.di.AppComponent
import com.nazartaraniuk.unsplashtesttask.presentation.di.DaggerAppComponent

class MainApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.builder().application(this).build()
    }

    override fun onCreate() {
        super.onCreate()
    }
}
