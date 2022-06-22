package com.example.latestnewsapp.data.repository.dataSourceImpl

import com.example.latestnewsapp.data.db.ArticlesDao
import com.example.latestnewsapp.data.model.Article
import com.example.latestnewsapp.data.repository.dataSource.NewsLocalDataSource
import kotlinx.coroutines.flow.Flow

class NewsLocalDataSourceImpl(
    private val articlesDao: ArticlesDao
): NewsLocalDataSource {
    override suspend fun saveArticleToDB(article: Article) {
        articlesDao.insert(article)
    }

    override fun getSavedArticles(): Flow<List<Article>> {
        return articlesDao.getAllArticles()
    }

    override suspend fun deleteArticlesFromDB(article: Article) {
        articlesDao.deleteArticle(article)
    }
}