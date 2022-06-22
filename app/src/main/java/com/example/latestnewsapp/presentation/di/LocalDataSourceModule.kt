package com.example.latestnewsapp.presentation.di

import com.example.latestnewsapp.data.db.ArticlesDao
import com.example.latestnewsapp.data.repository.dataSource.NewsLocalDataSource
import com.example.latestnewsapp.data.repository.dataSourceImpl.NewsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalDataSourceModule {

    @Singleton
    @Provides
    fun providesLocalDataSource(
        articlesDao: ArticlesDao
    ): NewsLocalDataSource{
        return NewsLocalDataSourceImpl(
            articlesDao
        )
    }

}