package com.example.latestnewsapp.presentation.di

import com.example.latestnewsapp.data.api.NewsService
import com.example.latestnewsapp.data.repository.dataSource.NewsRemoteDataSource
import com.example.latestnewsapp.data.repository.dataSourceImpl.NewsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RemoteDataSourceModule {
    @Singleton
    @Provides
    fun provideNewsRemoteDataSource(
        newsService: NewsService
    ): NewsRemoteDataSource{
        return NewsRemoteDataSourceImpl(
            newsService
        )
    }
}