package com.example.latestnewsapp.domain.useCase

import com.example.latestnewsapp.data.model.Article
import com.example.latestnewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(private val newsRepository: NewsRepository) {
    fun execute(): Flow<List<Article>>{
        return newsRepository.getSavedNews()
    }
}