package com.example.testnewsapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testnewsapp.presentation.SavedArticlesScreen
import com.example.testnewsapp.presentation.screens.SharedViewModel
import com.example.testnewsapp.presentation.screens.articleDetailScreen.ArticleDetailScreen
import com.example.testnewsapp.presentation.screens.articlesScreen.ArticlesScreen

@Composable
fun NavGraph(navController: NavHostController, viewModel: SharedViewModel) {
    NavHost(navController, startDestination = "articlesScreen") {
        composable("articlesScreen") {
            ArticlesScreen(viewModel = viewModel, navController = navController)
        }
        composable("articleDetailScreen") {
            ArticleDetailScreen(navController = navController, viewModel = viewModel)
        }
        composable("savedArticlesScreen") {
            viewModel.getAllArticleFromDB()
            SavedArticlesScreen(navController = navController, viewModel = viewModel)
        }
    }
}