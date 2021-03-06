package com.everythingjetpackpro.zomatocomposew

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.ui.tooling.preview.Preview
import com.everythingjetpackpro.zomatocomposew.ui.RestaurantCardBig
import com.everythingjetpackpro.zomatocomposew.ui.RestaurantCardSmall
import com.everythingjetpackpro.zomatocomposew.ui.ZomatoComposeTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ZomatoComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    RestaurantCardBig("Android"){

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ZomatoComposeTheme {
        Greeting("Android")
    }
}