package com.nazartaraniuk.unsplashtesttask.presentation.di

import com.nazartaraniuk.unsplashtesttask.data.LocalRepositoryImpl
import com.nazartaraniuk.unsplashtesttask.data.NetworkRepositoryImpl
import com.nazartaraniuk.unsplashtesttask.domain.repositories.LocalRepository
import com.nazartaraniuk.unsplashtesttask.domain.repositories.NetworkRepository
import dagger.Binds
import dagger.Module

@Module
interface BindModule {

    @Binds
    fun bindNetworkRepository(repositoryImpl: NetworkRepositoryImpl) : NetworkRepository

    @Binds
    fun bindLocalRepository(repositoryImpl: LocalRepositoryImpl) : LocalRepository
}