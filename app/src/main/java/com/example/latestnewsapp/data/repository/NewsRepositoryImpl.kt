package com.example.latestnewsapp.data.repository

import com.example.latestnewsapp.data.model.Article
import com.example.latestnewsapp.data.model.NewsResponse
import com.example.latestnewsapp.data.repository.dataSource.NewsRemoteDataSource
import com.example.latestnewsapp.data.util.Resource
import com.example.latestnewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource
): NewsRepository {
    override suspend fun getNewsHeadlines(country: String,page: Int): Resource<NewsResponse> {
        return responseToResource(newsRemoteDataSource.getTopHeadlines(country,page))
    }

    private fun responseToResource(response: Response<NewsResponse>):Resource<NewsResponse>{
        if(response.isSuccessful){
            response.body()?.let {result->
                return Resource.Success(result)
            }
        }
        return Resource.Error(response.message())
    }

    override suspend fun searchNews(searchQuery: String): Resource<NewsResponse> {
        TODO("Not yet implemented")
    }

    override suspend fun saveNews(article: Article) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteNews(article: Article) {
        TODO("Not yet implemented")
    }

    override fun getSavedNews(): Flow<List<Article>> {
        TODO("Not yet implemented")
    }

}