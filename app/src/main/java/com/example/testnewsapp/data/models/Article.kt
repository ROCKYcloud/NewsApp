package com.example.testnewsapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "articles"
)
data class Article(
    @PrimaryKey(autoGenerate = true)
    val id: Long? =null,
    var author: String ,
    val content: String,
    val description: String,
    var publishedAt: String,
    val source: Source,
    val title: String,
    val urlToImage: String
)  : Serializable