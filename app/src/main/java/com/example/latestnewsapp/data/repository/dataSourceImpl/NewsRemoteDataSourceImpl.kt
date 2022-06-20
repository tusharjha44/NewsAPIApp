package com.example.latestnewsapp.data.repository.dataSourceImpl

import com.example.latestnewsapp.data.api.NewsService
import com.example.latestnewsapp.data.model.NewsResponse
import com.example.latestnewsapp.data.repository.dataSource.NewsRemoteDataSource
import retrofit2.Response

class NewsRemoteDataSourceImpl(
        private val newsAPIService: NewsService
): NewsRemoteDataSource {
    override suspend fun getTopHeadlines(country: String,page: Int): Response<NewsResponse> {
          return newsAPIService.getTopHeadlines(country,page)
    }
}