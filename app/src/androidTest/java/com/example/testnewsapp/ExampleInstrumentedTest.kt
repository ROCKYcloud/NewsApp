package com.example.testnewsapp

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.testnewsapp.domain.db.ArticleDao
import com.example.testnewsapp.domain.db.ArticleDatabase

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import android.content.Context
import com.example.testnewsapp.data.models.Article
import com.example.testnewsapp.data.models.Source
import kotlinx.coroutines.runBlocking
import org.junit.After
import java.io.IOException

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    private lateinit var articleDao: ArticleDao
    private lateinit var db: ArticleDatabase

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.testnewsapp", appContext.packageName)
    }

    @Test
    fun insertArticle()= runBlocking {
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
        assertEquals(articles.isNotEmpty(),true)
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
        assertEquals(!articles.contains(article),true)
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