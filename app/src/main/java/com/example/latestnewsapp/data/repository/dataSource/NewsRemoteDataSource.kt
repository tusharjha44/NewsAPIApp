package com.example.latestnewsapp.data.repository.dataSource

import com.example.latestnewsapp.data.model.NewsResponse
import retrofit2.Response

interface NewsRemoteDataSource {

    suspend fun getTopHeadlines(
        country: String,
        page: Int
    ):Response<NewsResponse>

    suspend fun getSearchedTopHeadlines(
        country: String,
        searchedQuery: String,
        page: Int
    ): Response<NewsResponse>
}