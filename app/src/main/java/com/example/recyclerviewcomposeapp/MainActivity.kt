@file:OptIn(ExperimentalGlideComposeApi::class)

package com.example.recyclerviewcomposeapp

import android.os.Bundle
import android.text.Layout.Alignment
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.recyclerviewcomposeapp.model.EmployDetails
import com.example.recyclerviewcomposeapp.ui.theme.RecyclerviewComposeAppTheme
import com.example.recyclerviewcomposeapp.util.Details
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
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailsContent(){
    val employees = remember {
        Details.EmployDetailsList
    }
    LazyColumn(contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)){
        items(employees){
            EmployeeCard(emp = it)
        }
    }
}

@ExperimentalGlideComposeApi
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun EmployeeCard(emp: EmployDetails) {
    ElevatedCard(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
            colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        shape = RoundedCornerShape(corner = CornerSize(16.dp)),
        elevation = CardDefaults.cardElevation(
                defaultElevation = 2.dp
                ),

    ) {
//        Row(modifier = Modifier.padding(20.dp)){
//            Column(modifier = Modifier.weight(1f),
//                Arrangement.Center){
//                Text(text = emp.title,
//                style = TextStyle(
//                    color = Color.Black,
//                    fontSize = 22.sp,
//                    fontWeight = FontWeight.Bold)
//                )
//
//                Text(text = "Age :- "+emp.age.toString(),
//                    style = TextStyle(
//                        color = Color.Black,
//                        fontSize = 15.sp
//                    )
//                )
//
//                Text(text = "Sex :- " + emp.sex,
//                    style = TextStyle(
//                        color = Color.Black,
//                        fontSize = 15.sp
//                    ))
//            }
//
//            Image(painter = painterResource(id = emp.ImageId), contentDescription = "Profile Image",
//                contentScale = ContentScale.FillHeight,
//                modifier = Modifier
//                    .padding(8.dp)
//                    .size(110.dp)
//                    .clip((CircleShape)))
//        }

        Row(
            modifier = Modifier.padding(20.dp)){
                GlideImage(
                modifier = Modifier.padding(5.dp).fillMaxSize(),
                model = "https://i.pinimg.com/236x/2b/cb/d8/2bcbd874fc1e841364379ecbf7df681c.jpg",
                contentDescription = "Image Url"
            ){
                    it.load("https://i.pinimg.com/236x/2b/cb/d8/2bcbd874fc1e841364379ecbf7df681c.jpg")
                }


        }

        Text(text = emp.title,
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold),
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )

        Text(text = emp.description,
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
