package com.example.testnewsapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.testnewsapp.data.model.Article
import com.example.testnewsapp.presenter.SavedArticlesScreen
import com.example.testnewsapp.presenter.SharedViewModel
import com.example.testnewsapp.presenter.articleDetailScreen.ArticleDetailScreen
import com.example.testnewsapp.presenter.articlesScreen.ArticlesScreen

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