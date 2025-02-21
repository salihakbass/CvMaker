package com.salihakbas.cvmaker.di

import com.salihakbas.cvmaker.data.repository.MainRepositoryImpl
import com.salihakbas.cvmaker.domain.repository.MainRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindMainRepository(repositoryImpl: MainRepositoryImpl): MainRepository
}