package com.example.testnewsapp.presenter

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.testnewsapp.presenter.articlesScreen.item.ArtcleItem

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