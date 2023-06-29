package com.example.testnewsapp.data.model

data class News(
    var articles: List<Article>,
    val status: String,
    val totalResults: Int
)