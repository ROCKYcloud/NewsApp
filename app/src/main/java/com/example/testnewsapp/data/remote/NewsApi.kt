package com.example.testnewsapp.data.remote

import com.example.testnewsapp.data.model.News
import com.example.testnewsapp.util.Constants
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("top-headlines")
    suspend fun getNewsArticles(
        @Query("country") country: String = "us",
        @Query("apiKey") apiKey: String = Constants.API_KEY
    ): Response<News>

    @GET("everything")
    suspend fun getSearchNews(
        @Query("page")
        pageNumber: Int = 1,
        @Query("q")
        searchQuery: String,
        @Query("apiKey")
        apiKey: String = Constants.API_KEY
    ): Response<News>
}