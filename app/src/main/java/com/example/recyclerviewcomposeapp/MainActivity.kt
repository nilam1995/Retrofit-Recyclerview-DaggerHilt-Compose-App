@file:OptIn(ExperimentalGlideComposeApi::class)

package com.example.recyclerviewcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.example.recyclerviewcomposeapp.model.Article
import com.example.recyclerviewcomposeapp.ui.screen.DetailContent
import com.example.recyclerviewcomposeapp.ui.screen.NewsDetailScreen
import com.example.recyclerviewcomposeapp.ui.theme.RecyclerviewComposeAppTheme
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
//                    App()
//                    dummy()
                    InstagramProfileUi()
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun dummy(){
//    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.SpaceBetween,
//
//    ) {
//        Text(text = buildAnnotatedString {
//            withStyle(style = SpanStyle(
//                color = Color.Yellow,
//                fontSize = 30.sp
//            )){
//                append("new")
//            }
//
//            append("bob1")
//        })
//        Text(text = "bob2")
//        Text(text = "bob3")
//        Text(text = "bob4")
//    }


    //snackbar
//    val scope = rememberCoroutineScope()
//    val snackbarHostState = remember { SnackbarHostState() }
//    Scaffold(
//        snackbarHost = {
//            SnackbarHost(hostState = snackbarHostState)
//        },
//        floatingActionButton = {
//            ExtendedFloatingActionButton(
//                text = { Text("") },
//                icon = { Icon(Icons.Filled.Delete, contentDescription = "") },
//                onClick = {
//                    scope.launch {
//                        val result = snackbarHostState
//                            .showSnackbar(
//                                message = "Snackbar",
//                                actionLabel = "Action",
//                                // Defaults to SnackbarDuration.Short
//                                duration = SnackbarDuration.Indefinite
//                            )
//                        when (result) {
//                            SnackbarResult.ActionPerformed -> {
//                                /* Handle snackbar action performed */
//                            }
//                            SnackbarResult.Dismissed -> {
//                                /* Handle snackbar dismissed */
//                            }
//                        }
//                    }
//                }
//            )
//        }
//    ) { contentPadding ->
//
//    }

//    ConstraintLayout {
//        val(button, text) = createRefs()
//        val topGuideline = createGuidelineFromTop(100.dp)
//
//        Button(onClick = { },
//            modifier = Modifier.constrainAs(button){
//                    top.linkTo(parent.top)
//            }) {
//            Text(text = "SUBMIT")
//        }
//
//        Text(text = "Hello World", modifier = Modifier.constrainAs(text) {
//            top.linkTo(topGuideline)
//            start.linkTo(button.end)
//        })
//    }
}

@Preview(showBackground = true)
@Composable
fun InstagramProfileUi(){
    Column(modifier = Modifier
        .background(Color.White)
        .fillMaxSize()
        .padding(15.dp))
    {
        TopBar("admin_123")
        ProfileSection()
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun TopBar(name: String) {
    ConstraintLayout {
        val (icon, text) = createRefs()

        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "backArrow",
            tint = Color.Black, modifier = Modifier.constrainAs(icon){
                top.linkTo(parent.top)
            }.size(20.dp))
        Text(text = name, fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(15.dp, 0.dp))
    }
}

@Composable
fun ProfileSection(){
    Row {
//        Image(painter = , contentDescription = )
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
}

sealed class Screen {
    object Main : Screen()
    data class Detail(val article: Article) : Screen()
}




