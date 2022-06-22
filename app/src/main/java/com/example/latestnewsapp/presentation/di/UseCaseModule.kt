package com.example.latestnewsapp.presentation.di

import com.example.latestnewsapp.domain.repository.NewsRepository
import com.example.latestnewsapp.domain.useCase.GetNewsHeadlinesUseCase
import com.example.latestnewsapp.domain.useCase.GetSavedNewsUseCase
import com.example.latestnewsapp.domain.useCase.SaveNewsUseCase
import com.example.latestnewsapp.domain.useCase.SearchedNewsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCaseModule {

    @Singleton
    @Provides
    fun provideGetNewsHeadlineUseCase(
        newsRepository: NewsRepository
    ): GetNewsHeadlinesUseCase{
        return GetNewsHeadlinesUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun provideGetSearchedNewsHeadlineUseCase(
        newsRepository: NewsRepository
    ): SearchedNewsUseCase{
        return SearchedNewsUseCase(newsRepository)
    }

    @Singleton
    @Provides
    fun provideSaveNewsUseCase(
        newsRepository: NewsRepository
    ): SaveNewsUseCase {
        return SaveNewsUseCase(newsRepository)
    }



}