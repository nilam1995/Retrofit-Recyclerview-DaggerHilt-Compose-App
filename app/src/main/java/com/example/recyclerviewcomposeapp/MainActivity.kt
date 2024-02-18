@file:OptIn(ExperimentalGlideComposeApi::class)

package com.example.recyclerviewcomposeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.isSystemInDarkTheme
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.recyclerviewcomposeapp.model.Article
import com.example.recyclerviewcomposeapp.model.NewsDetailResponse
import com.example.recyclerviewcomposeapp.ui.screen.DetailContent
import com.example.recyclerviewcomposeapp.ui.screen.NewsDetailScreen
import com.example.recyclerviewcomposeapp.ui.theme.RecyclerviewComposeAppTheme
import com.example.recyclerviewcomposeapp.viewmodel.MainActivityViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RecyclerviewComposeAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App(){
    var currentScreen by remember { mutableStateOf<Screen>(Screen.Main) }

    when (currentScreen) {
        is Screen.Main -> {
            DetailContent(onClick = { article ->
                currentScreen = Screen.Detail(article)
            })
        }
        is Screen.Detail -> {
            NewsDetailScreen(article = (currentScreen as Screen.Detail).article,  onBackClick = {
                // When the back button is clicked, navigate back to the main screen
                currentScreen = Screen.Main
            })
        }
    }

//    DetailContent(){
//        NewsDetail(article = it)
//    }
}

//@Composable
//fun NewsDetail(article: Article) {
//    NewsDetailScreen(article = article)
//}

sealed class Screen {
    object Main : Screen()
    data class Detail(val article: Article) : Screen()
}




