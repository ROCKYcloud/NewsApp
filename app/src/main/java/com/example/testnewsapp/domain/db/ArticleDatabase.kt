package com.example.testnewsapp.domain.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.testnewsapp.data.models.Article

@Database(entities = [Article::class], version = 1,exportSchema = false)
@TypeConverters(Converters::class)
abstract class ArticleDatabase : RoomDatabase() {
    abstract fun getArticleDao(): ArticleDao
}