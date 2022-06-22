package com.example.latestnewsapp.data.db

import androidx.room.*
import com.example.latestnewsapp.data.model.Article
import kotlinx.coroutines.flow.Flow

@Dao
interface ArticlesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(article: Article)
//
//    @Query("SELECT * FROM articles")
//    fun getAllArticles(): Flow<List<Article>>
//
//    @Delete
//    suspend fun deleteArticle(article: Article)


}
