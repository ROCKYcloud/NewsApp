package com.example.testnewsapp.presenter.articlesScreen.item

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AvailableParamsItem(onClick: (searchQuery: String) -> Unit = {}) {
    LazyRow() {
        items(availableParams) {
            Button(
                onClick = { onClick(it) },
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 4.dp),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(text = it)
            }
        }
    }
}

val availableParams = listOf("Ukraine", "Cryptocurrency", "USA", "BBC", "Breaking News")