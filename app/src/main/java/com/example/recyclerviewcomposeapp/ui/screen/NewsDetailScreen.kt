package com.example.recyclerviewcomposeapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.recyclerviewcomposeapp.model.Article

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun NewsDetailScreen(article: Article, onBackClick: () -> Unit){
    Column{
        Text("Detail Screen", modifier = Modifier.padding(24.dp),
            style = MaterialTheme.typography.titleLarge,  color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold)
        GlideImage(
            modifier = Modifier
                .padding(5.dp)
                .height(400.dp),
            model = article.urlToImage,
            contentDescription = "Image Url"
        ) {
            it.load(article.urlToImage)
        }
        Text(text = article.title, modifier = Modifier.padding(16.dp))
        Text(text = article.description, modifier = Modifier.padding(16.dp))
        Button(onClick = onBackClick, modifier = Modifier.padding(16.dp)) {
            Text("Back")
        }
    }

}