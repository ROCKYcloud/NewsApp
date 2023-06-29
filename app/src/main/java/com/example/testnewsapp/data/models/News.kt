package com.example.testnewsapp.data.models

data class News(
    var articles: List<Article>,
    val status: String,
    val totalResults: Int
)