package com.everythingjetpackpro.compose101

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollableColumn
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.ui.tooling.preview.Preview
import com.everythingjetpackpro.compose101.ui.Compose101Theme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MyScreenContent()
            }

        }
    }
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(
        onClick = { updateCount(count + 1) },
        backgroundColor = if (count > 5) Color.Green else Color.White
    ) {
        Text("I've been clicked $count times")
    }
}

@Composable
fun Greeting(name: String) {
    Text (
        text = "Hello $name!",
        modifier = Modifier.padding(24.dp),
        style = MaterialTheme.typography.h1
    )}

@Composable
fun MyScreenContent(names: List<String> = listOf("Android", "there")) {
    val count = remember { mutableStateOf(0) }
    Column(modifier = Modifier.fillMaxHeight()) {
        ScrollableColumn(modifier = Modifier.weight(1f)) {
            for (name in names) {
                Greeting(name = name)
                Divider(color = Color.Black)
            }
        }
        Divider(color = Color.Transparent, thickness = 32.dp)
        Counter(
            count.value,
            updateCount = { newCount ->
                count.value = newCount
            }
        )
    }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    Compose101Theme {
        Surface(color = Color.Yellow) {
            content()
        }
    }
}


@Preview(showBackground = true, name = "Text preview")
@Composable
fun DefaultPreview() {
    MyApp {
        MyScreenContent(listOf("Hello", "Pulkit", "Aggarwal"))
    }
}

@Composable
fun NewStory() {

    val image = imageResource(R.drawable.header)
    MaterialTheme {
        val typography = MaterialTheme.typography

        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            val imageModifier = Modifier
                .preferredHeight(180.dp)
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(12.dp))


            Image(
                image, modifier = imageModifier,
                contentScale = ContentScale.Crop
            )

            Spacer(Modifier.preferredHeight(16.dp))
            Text(
                "A day wandering through the sandhills " +
                        "in Shark Fin Cove, and a few of the " +
                        "sights I saw",
                style = typography.h6,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                "Davenport, California",
                style = typography.body2
            )
            Text(
                "December 2018",
                style = typography.body2
            )
        }
    }

}