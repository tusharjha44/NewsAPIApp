package com.example.latestnewsapp.domain.useCase

import com.example.latestnewsapp.data.model.Article
import com.example.latestnewsapp.domain.repository.NewsRepository

class SaveNewsUseCase(private val newsRepository: NewsRepository) {
    suspend fun execute(article: Article) = newsRepository.saveNews(article)

}