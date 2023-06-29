package com.example.testnewsapp.presentation.screens

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testnewsapp.data.models.Article
import com.example.testnewsapp.domain.repository.NewsRepository
import com.example.testnewsapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

@HiltViewModel
class SharedViewModel @Inject constructor(
    val repo: NewsRepository
) : ViewModel() {
    var articles = mutableStateOf<List<Article>>(listOf())
    var articlesFromDB = mutableStateOf<List<Article>>(listOf())
    var article by mutableStateOf<Article?>(null)
        private set

    fun addArticle(newArticle: Article) {
        article = newArticle
    }

    var isLoading = mutableStateOf(false)

    init {
        getArticles()
    }

    fun getArticles() {
        viewModelScope.launch {
            isLoading.value = true
            when (val resolt = repo.getArticles()) {
                is Resource.Loading -> {
                    isLoading.value = true
                }
                is Resource.Success -> {
                    isLoading.value = false
                    articles.value = resolt.data!!
                }
                is Resource.Error -> {
                    isLoading.value = false
                }
            }
        }
    }

    fun getSearchNews(searchQuery: String) {
        viewModelScope.launch {
            when (val resolt = repo.getSearchNews(searchQuery = searchQuery)) {
                is Resource.Loading -> {
                    isLoading.value = true
                }
                is Resource.Success -> {
                    isLoading.value = false
                    articles.value = resolt.data!!
                }
                is Resource.Error -> {
                    isLoading.value = false
                }
            }
        }
    }

    fun addArticleToDB(article: Article) {
        CoroutineScope(Dispatchers.IO).launch {
            repo.addArticleToDB(article)
        }
    }

    fun deleteArticleFromDB(article: Article) {
        CoroutineScope(Dispatchers.IO).launch {
            repo.deleteArticleFromDB(article)
        }
    }
    fun getAllArticleFromDB() {
        CoroutineScope(Dispatchers.IO).launch {
            articlesFromDB.value = repo.getAllArticleFromDB()
        }
    }
}