package com.developer.viewmodel2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.developer.viewmodel2.model.User
import com.developer.viewmodel2.model.ViewModelUser
import com.developer.viewmodel2.ui.theme.ViewModel2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewModel2Theme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    val modelUser = viewModels<ViewModelUser>().value
                    HomeScreen(modelUser)
                }
            }
        }
    }
}

@Composable
fun HomeScreen(modelUser: ViewModelUser) {
    Scaffold() {
        ListContent(modelUser)
    }
}

@Composable
fun ListContent(modelUser: ViewModelUser) {
    LazyColumn {
        items(modelUser.dataUser) { item ->
            ContentHomeScreenItem(it = item)
        }
        item(){
            Row() {
                Button(onClick = {
                    modelUser.addUser(
                        User(R.drawable.avatar, "THANGDEEPTRY")
                    )
                },
                modifier = Modifier.weight(1f)){
                    Text(text = "ADD USER")
                }

                Button(onClick = {
                    modelUser.removeAtIndex(0)
                }, modifier = Modifier.weight(1f)){
                    Text(text = "REMOVE USER")
                }

                Button(onClick = {
                    modelUser.editAtIndex(0,
                        User(
                            R.drawable.avatar, "Phương")
                    )
                }, modifier = Modifier.weight(1f)){
                    Text(text = "EDIT USER")
                }
            }
        }
    }
}

@Composable
fun ContentHomeScreenItem(
    modifier: Modifier = Modifier,
    it: User
) {

    Box(modifier = modifier) {
        Column() {
            Image(
                painter = painterResource(id = it.avatar),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )

            Text(
                text = it.name,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(modelUser = ViewModelUser())
}