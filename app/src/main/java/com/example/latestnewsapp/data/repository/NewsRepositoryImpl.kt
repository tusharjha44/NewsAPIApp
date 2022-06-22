package com.example.latestnewsapp.data.repository

import com.example.latestnewsapp.data.model.Article
import com.example.latestnewsapp.data.model.NewsResponse
import com.example.latestnewsapp.data.repository.dataSource.NewsLocalDataSource
import com.example.latestnewsapp.data.repository.dataSource.NewsRemoteDataSource
import com.example.latestnewsapp.data.util.Resource
import com.example.latestnewsapp.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

class NewsRepositoryImpl(
    private val newsRemoteDataSource: NewsRemoteDataSource,
    private val newsLocalDataSource: NewsLocalDataSource
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

    override suspend fun searchNews(country: String,searchQuery: String,page: Int): Resource<NewsResponse> {
        return responseToResource(newsRemoteDataSource.getSearchedTopHeadlines(country,searchQuery,page))
    }

    override suspend fun saveNews(article: Article) {
        newsLocalDataSource.saveArticleToDB(article)
    }

    override suspend fun deleteNews(article: Article) {
//        newsLocalDataSource.deleteArticlesFromDB(article)
        TODO()
    }


    override fun getSavedNews(): Flow<List<Article>> {
//        return newsLocalDataSource.getSavedArticles()
    TODO()
    }

}