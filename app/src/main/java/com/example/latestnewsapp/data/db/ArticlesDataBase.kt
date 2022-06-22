package com.example.latestnewsapp.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.latestnewsapp.data.model.Article

@Database(
    entities = [Article::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Convertors::class)
abstract class ArticlesDataBase: RoomDatabase() {

    abstract fun getArticleDao(): ArticlesDao

}