package com.example.ktor_client

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ktor_client.ui.theme.KTOR_CLientTheme

class MainActivity : ComponentActivity() {
    private val service= PostService.createKtor()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val posts = produceState<List<PostResponse>>(
                initialValue = emptyList(),
                producer = {
                    value = service.getposts()
                }
            )
            KTOR_CLientTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    LazyColumn {
                        items(posts.value){
                            Column (
                                modifier=Modifier.fillMaxWidth().padding(16.dp)
                            ){
                                Text(text = it.title, fontSize = 20.sp,color= Color.White)
                                Spacer(modifier = Modifier.height(4.dp))
                                Text(text = it.body, fontSize = 20.sp,color=Color.White)
                            }
                        }
                    }
                }
            }
        }
    }
}

