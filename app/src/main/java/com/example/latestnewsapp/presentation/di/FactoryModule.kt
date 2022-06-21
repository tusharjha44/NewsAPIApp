package com.example.latestnewsapp.presentation.di

import android.app.Application
import com.example.latestnewsapp.domain.useCase.GetNewsHeadlinesUseCase
import com.example.latestnewsapp.domain.useCase.SearchedNewsUseCase
import com.example.latestnewsapp.presentation.viewModel.NewsViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FactoryModule {

    @Singleton
    @Provides
    fun provideNewsViewModelFactory(
        app: Application,
        getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase,
        getSearchedNewsUseCase: SearchedNewsUseCase
    ): NewsViewModelFactory{
        return NewsViewModelFactory(
            app,
            getNewsHeadlinesUseCase,
            getSearchedNewsUseCase
        )
    }

}