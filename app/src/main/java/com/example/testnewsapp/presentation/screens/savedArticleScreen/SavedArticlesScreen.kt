package com.example.testnewsapp.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.testnewsapp.presentation.items.ArtcleItem
import com.example.testnewsapp.presentation.screens.SharedViewModel

@Composable
fun SavedArticlesScreen(
    viewModel: SharedViewModel,
    navController: NavController
) {
    val articles by remember { viewModel.articlesFromDB }

    articles.let { list ->
        LazyColumn() {
            items(list) { item ->
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopEnd) {
                    ArtcleItem(article = item, onClick = {
                        viewModel.addArticle(item)
                        navController.navigate("articleDetailScreen")
                    })
                }
            }
        }
    }
}