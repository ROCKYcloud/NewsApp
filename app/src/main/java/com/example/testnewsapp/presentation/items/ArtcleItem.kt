package com.example.testnewsapp.presentation.items

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.testnewsapp.R
import com.example.testnewsapp.data.models.Article

@Composable
fun ArtcleItem(article: Article, onClick: () -> Unit = {}) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onClick() }
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxWidth(),
            model = article.urlToImage,
            contentDescription = "",
            placeholder = painterResource(id = R.drawable.ic_launcher_foreground),
            contentScale = ContentScale.Crop
        )
        Text(
            text = article.title,
            modifier = Modifier.padding(horizontal = 8.dp),
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            maxLines = 3
        )
    }
}