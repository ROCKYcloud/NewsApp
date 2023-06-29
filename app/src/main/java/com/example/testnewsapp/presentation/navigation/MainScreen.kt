package com.example.testnewsapp.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.testnewsapp.presentation.screens.SharedViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val viewModel: SharedViewModel = hiltViewModel()
    Scaffold(bottomBar = {
        BottomBar(navController = navController)
    }) {
        NavGraph(navController, viewModel)
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(BottomBarScreen.News, BottomBarScreen.Saved)
    val backStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = backStackEntry?.destination

    BottomNavigation() {
        screens.forEach() { screen ->
            AddItem(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun AddItem(
    screen: BottomBarScreen,
    currentDestination: NavDestination?,
    navController: NavHostController
) {
    NavigationRailItem(
        modifier = Modifier.padding(horizontal = 50.dp),
        label = { Text(text = screen.title) },
        icon = { Icon(imageVector = screen.Icon, contentDescription = "Nav Item") },
        selected = currentDestination?.hierarchy?.any {
            it.route == screen.route
        } == true,
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        })
}