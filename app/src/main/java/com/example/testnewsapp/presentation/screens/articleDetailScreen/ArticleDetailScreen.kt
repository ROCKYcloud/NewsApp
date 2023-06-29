package com.example.testnewsapp.presentation.screens.articleDetailScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.testnewsapp.presentation.screens.SharedViewModel

@Composable
fun ArticleDetailScreen(navController: NavController, viewModel: SharedViewModel) {

    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        viewModel.article?.let {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = { navController.popBackStack() },
                    modifier = Modifier.padding(vertical = 16.dp),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(text = "back")
                }
                Text(
                    text = it.source.name,
                    modifier = Modifier,
                    fontSize = 24.sp
                )
                Button(
                    onClick = {
                        viewModel.addArticleToDB(article = it)
                    },
                    modifier = Modifier.padding(vertical = 16.dp),
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Text(text = "save")
                }
            }
            Text(
                text = it.title,
                modifier = Modifier.padding(vertical = 16.dp),
                color = Color.Black,
                fontSize = 20.sp
            )
            AsyncImage(
                modifier = Modifier.fillMaxWidth(),
                model = viewModel.article?.urlToImage,
                contentDescription = ""
            )

            Text(
                text = it.description,
                modifier = Modifier.padding(vertical = 16.dp),
                fontSize = 18.sp
            )
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = it.author ?: "",
                    modifier = Modifier,
                    fontSize = 18.sp
                )
                Text(
                    text = it.publishedAt,
                    modifier = Modifier,
                    fontSize = 14.sp
                )
            }
        }
    }
}