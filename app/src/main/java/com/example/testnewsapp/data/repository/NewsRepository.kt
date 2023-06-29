package com.example.testnewsapp.data.repository

import android.util.Log
import androidx.annotation.WorkerThread
import androidx.compose.runtime.MutableState
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.testnewsapp.data.model.Article
import com.example.testnewsapp.data.remote.NewsApi
import com.example.testnewsapp.db.ArticleDao
import com.plcoding.jetpackcomposepokedex.util.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject


class NewsRepository @Inject constructor(
    private val api: NewsApi,
    private val articleDao: ArticleDao
) {
    suspend fun getArticles(): Resource<List<Article>> {
        return try {
            val resp = api.getNewsArticles()
            if (resp.isSuccessful) {
                Resource.Success(resp.body()?.articles)
            } else {
                Resource.Error(message = "${resp.code()}")
            }
        } catch (e: Exception) {
            Resource.Error("$e")
        }
    }

    suspend fun getSearchNews(searchQuery: String): Resource<List<Article>> {
        return try {
            val resp = api.getSearchNews(searchQuery = searchQuery)
            if (resp.isSuccessful) {
                Resource.Success(resp.body()?.articles)
            } else {
                Resource.Error(message = "${resp.code()}")
            }
        } catch (e: Exception) {
            Resource.Error("$e")
        }
    }

    suspend fun addArticleToDB(article: Article) {
        articleDao.insert(article)
    }

    suspend fun deleteArticleFromDB(article: Article) {
            articleDao.deleteArticle(article)
    }

    suspend fun getAllArticleFromDB() : List<Article> {
       return articleDao.getAllArticles()
   }



}