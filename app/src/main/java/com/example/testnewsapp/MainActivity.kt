package com.example.testnewsapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import com.example.testnewsapp.presenter.SharedViewModel
import com.example.testnewsapp.navigation.MainScreen
import com.example.testnewsapp.ui.theme.TestNewsAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestNewsAppTheme() {
                MainScreen()
            }
        }
    }
}

@Composable
fun NavGraph(navController: NavHostController, viewModel: SharedViewModel) {

}
