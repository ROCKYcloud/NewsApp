package com.example.testnewsapp.presentation.screens.articlesScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.testnewsapp.presentation.items.ArtcleItem
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.testnewsapp.presentation.screens.SharedViewModel
import com.example.testnewsapp.presentation.items.AvailableParamsItem
import com.example.testnewsapp.presentation.items.SearchView

@Composable
fun ArticlesScreen(viewModel: SharedViewModel, navController: NavController) {
    val articles by remember { viewModel.articles }
    val isLoading by remember { viewModel.isLoading }

    if (isLoading) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            CircularProgressIndicator(color = Color.Blue)
        }

    }
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp)) {
        SearchView(hint = "Search...", modifier = Modifier.height(50.dp)) {
            viewModel.getSearchNews(searchQuery = it)
        }
        AvailableParamsItem() {
            viewModel.getSearchNews(it)
        }
        articles.let { list ->
            LazyColumn() {
                items(list) { item ->
                    ArtcleItem(article = item, onClick = {
                        viewModel.addArticle(item)
                        navController.navigate("articleDetailScreen")
                    })
                }
            }
        }
    }
}