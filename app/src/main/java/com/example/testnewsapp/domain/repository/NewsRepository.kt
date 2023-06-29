package com.example.testnewsapp.domain.repository

import com.example.testnewsapp.data.models.Article
import com.example.testnewsapp.data.remote.NewsApi
import com.example.testnewsapp.domain.db.ArticleDao
import com.example.testnewsapp.utils.Resource
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