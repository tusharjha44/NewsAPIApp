package com.example.latestnewsapp.data.api

import com.example.latestnewsapp.BuildConfig
import com.example.latestnewsapp.data.model.NewsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("/v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country")
        country: String,
        @Query("page")
        page: Int,
        @Query("apiKey")
        apiKey: String = BuildConfig.ApiKey
    ): Response<NewsResponse>

}