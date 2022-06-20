package com.example.latestnewsapp.domain.useCase

import com.example.latestnewsapp.data.model.NewsResponse
import com.example.latestnewsapp.data.util.Resource
import com.example.latestnewsapp.domain.repository.NewsRepository

class GetNewsHeadlinesUseCase(private val newsRepository: NewsRepository) {

    suspend fun execute(): Resource<NewsResponse>{
        return newsRepository.getNewsHeadlines()
    }

}