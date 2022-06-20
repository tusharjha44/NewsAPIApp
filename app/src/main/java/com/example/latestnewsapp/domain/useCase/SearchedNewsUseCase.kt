package com.example.latestnewsapp.domain.useCase

import com.example.latestnewsapp.data.model.NewsResponse
import com.example.latestnewsapp.data.util.Resource
import com.example.latestnewsapp.domain.repository.NewsRepository

class SearchedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(searchQuery: String): Resource<NewsResponse>{
        return newsRepository.searchNews(searchQuery)
    }

}