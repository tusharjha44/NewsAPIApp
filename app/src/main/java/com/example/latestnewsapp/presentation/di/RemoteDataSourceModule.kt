package com.example.latestnewsapp.presentation.di

import com.example.latestnewsapp.data.api.NewsService
import com.example.latestnewsapp.data.repository.dataSource.NewsRemoteDataSource
import com.example.latestnewsapp.data.repository.dataSourceImpl.NewsRemoteDataSourceImpl
import dagger.Provides
import javax.inject.Singleton

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