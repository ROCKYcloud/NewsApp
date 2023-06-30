package com.example.testnewsapp.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.testnewsapp.data.models.Article
import com.example.testnewsapp.data.models.Source
import com.example.testnewsapp.domain.db.ArticleDao
import com.example.testnewsapp.domain.db.ArticleDatabase
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4ClassRunner::class)
class NewsDataBaseTest : TestCase() {
    private lateinit var articleDao: ArticleDao
    private lateinit var db: ArticleDatabase

    @Test
    fun insertArticle() = runBlocking {
        val article = Article(
            id = 0,
            author = "author",
            content = "author",
            description = "author",
            publishedAt = "author",
            source = Source(id = "id", name = "name"),
            title = "",
            urlToImage = ""
        )
        articleDao.insert(article)
        val articles = articleDao.getAllArticles()
        Assert.assertEquals(articles.isNotEmpty(), true)
    }

    @Test
    fun deleteArticle() = runBlocking {
        val article = Article(
            id = 0,
            author = "author",
            content = "author",
            description = "author",
            publishedAt = "author",
            source = Source(id = "id", name = "name"),
            title = "",
            urlToImage = ""
        )

        articleDao.insert(article)
        articleDao.deleteArticle(article)
        val articles = articleDao.getAllArticles()
        Assert.assertEquals(!articles.contains(article), true)
    }

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, ArticleDatabase::class.java
        ).build()
        articleDao = db.getArticleDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }
}