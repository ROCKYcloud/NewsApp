package com.example.testnewsapp.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen(
    val route: String,
    val title: String,
    val Icon: ImageVector
) {
    object News : BottomBarScreen(
        route = "articlesScreen",
        title = "News",
        Icon = Icons.Rounded.List
    )

    object Saved : BottomBarScreen(
        route = "savedArticlesScreen",
        title = "Saved",
        Icon = Icons.Rounded.Star
    )
}