package com.example.testnewsapp.domain.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.testnewsapp.data.models.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    @Query("SELECT * FROM articles")
    suspend fun getAllArticles(): List<Article>

    @Delete
    suspend fun deleteArticle(article: Article)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(users: Article)
}