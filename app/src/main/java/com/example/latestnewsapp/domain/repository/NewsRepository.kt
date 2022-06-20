package com.example.latestnewsapp.domain.repository

import com.example.latestnewsapp.data.model.Article
import com.example.latestnewsapp.data.model.NewsResponse
import com.example.latestnewsapp.data.util.Resource
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    suspend fun getNewsHeadlines(country: String,page: Int): Resource<NewsResponse>
    suspend fun searchNews(searchQuery: String): Resource<NewsResponse>

    suspend fun saveNews(article: Article)
    suspend fun deleteNews(article: Article)
    fun getSavedNews(): Flow<List<Article>>



}