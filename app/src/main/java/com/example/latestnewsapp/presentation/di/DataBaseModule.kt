package com.example.latestnewsapp.presentation.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.latestnewsapp.data.db.ArticlesDao
import com.example.latestnewsapp.data.db.ArticlesDataBase
import com.example.latestnewsapp.data.model.Article
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataBaseModule {

    @Singleton
    @Provides
    fun providesNewsDataBase(application: Application): ArticlesDataBase{
        return Room.databaseBuilder(
            application,
            ArticlesDataBase::class.java,
            "news_db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun providesArticlesDao(articlesDataBase: ArticlesDataBase): ArticlesDao{
        return articlesDataBase.getArticleDao()
    }

}