package com.example.latestnewsapp.presentation.di

import com.example.latestnewsapp.data.repository.NewsRepositoryImpl
import com.example.latestnewsapp.data.repository.dataSource.NewsRemoteDataSource
import com.example.latestnewsapp.domain.repository.NewsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        remoteDataSource: NewsRemoteDataSource
    ): NewsRepository{
        return NewsRepositoryImpl(
            remoteDataSource
        )
    }

}