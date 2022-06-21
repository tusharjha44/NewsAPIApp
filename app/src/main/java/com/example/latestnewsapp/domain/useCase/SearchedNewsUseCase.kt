package com.example.latestnewsapp.domain.useCase

import com.example.latestnewsapp.data.model.NewsResponse
import com.example.latestnewsapp.data.util.Resource
import com.example.latestnewsapp.domain.repository.NewsRepository

class SearchedNewsUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(country: String,searchQuery: String,page: Int): Resource<NewsResponse>{
        return newsRepository.searchNews(country,searchQuery,page)
    }

}