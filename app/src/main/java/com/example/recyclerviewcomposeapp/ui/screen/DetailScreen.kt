package com.example.recyclerviewcomposeapp.ui.screen

import android.annotation.SuppressLint
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.recyclerviewcomposeapp.model.Article
import com.example.recyclerviewcomposeapp.viewmodel.MainActivityViewModel
import kotlinx.coroutines.flow.asStateFlow


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailContent(viewModel: MainActivityViewModel = hiltViewModel()) {
//    val viewModel: MainActivityViewModel = viewModel()
    val newsData = viewModel.newsData.collectAsState()

    // Render UI based on the observed data
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        val articles = newsData?.value?.articles.orEmpty()
        items(articles.size) { index ->
            val article = articles.getOrNull(index)
            if (article != null) {
                EmployeeCard(emp = article)
            } else {
                // Handle null article, you may display a placeholder or handle it differently
            }
        }
    }
}


@ExperimentalGlideComposeApi
@Composable
fun EmployeeCard(emp: Article) {
    ElevatedCard(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary,
        ),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),

        ) {
        Row(
            modifier = Modifier.padding(20.dp)){
            GlideImage(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxSize(),
                model = emp.urlToImage,
                contentDescription = "Image Url"
            ){
                it.load(emp.urlToImage)
            }
        }

        Text(text = emp.title,
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )

        Text(text = emp.content,
            style = TextStyle(
                color = Color.Black,
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraLight,
                textAlign = TextAlign.Left
            ),

            modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 16.dp)

        )


    }
}