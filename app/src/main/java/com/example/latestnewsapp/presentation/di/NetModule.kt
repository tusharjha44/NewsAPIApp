package com.example.latestnewsapp.presentation.di

import com.example.latestnewsapp.BuildConfig
import com.example.latestnewsapp.data.api.NewsService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class NetModule {

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit{
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BaseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun providesNewsService(retrofit: Retrofit): NewsService{
        return retrofit.create(NewsService::class.java)
    }

}