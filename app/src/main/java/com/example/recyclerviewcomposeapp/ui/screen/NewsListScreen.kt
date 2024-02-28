package com.example.recyclerviewcomposeapp.ui.screen

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.recyclerviewcomposeapp.model.Article
import com.example.recyclerviewcomposeapp.viewmodel.MainActivityViewModel


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun DetailContent(viewModel: MainActivityViewModel = hiltViewModel(), onClick: (news:Article) -> Unit) {
    val newsData = viewModel.newsData.collectAsState()
    val lazyListState = rememberLazyListState()

    LazyColumn(state = lazyListState,
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)) {
        val articles = newsData?.value?.articles.orEmpty()
        items(articles.size) { index ->
            val article = articles.getOrNull(index)
            if (article != null) {
                NewsListItem(emp = article){
                    onClick(it)
                }
            } else {
                // Handle null article, you may display a placeholder or handle it differently
            }
        }
    }
}


@ExperimentalGlideComposeApi
@Composable
fun NewsListItem(emp: Article, onClick: (news:Article) -> Unit) {
    if(emp.description!=null){
        ElevatedCard(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable { onClick(emp)},
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 2.dp
        ),
        ) {
            Row(
                modifier = Modifier.padding(20.dp)
            ) {
                GlideImage(
                    modifier = Modifier
                        .padding(5.dp)
                        .fillMaxSize(),
                    model = emp.urlToImage,
                    contentDescription = "Image Url",
                    contentScale = ContentScale.FillWidth
                ) {
                    it.load(emp.urlToImage)
                }
            }

            Text(
                text = emp.title,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                ),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                maxLines = 2
            )


            Text(
                text = emp.description,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.ExtraLight,
                    textAlign = TextAlign.Left
                ),
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 16.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis

            )
        }
    }
}