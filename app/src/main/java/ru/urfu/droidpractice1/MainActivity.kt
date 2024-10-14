package ru.urfu.droidpractice1
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.*
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import androidx.compose.ui.platform.LocalContext
import coil.compose.rememberAsyncImagePainter


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArticleScreen(context = this@MainActivity) // Передаем контекст
        }
    }
}

@Composable
fun ArticleScreen(context: Context) { // Принимаем контекст как параметр
    var likeCount by remember { mutableStateOf(0) }
    var dislikeCount by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = rememberAsyncImagePainter("https://ixbt.online/gametech/covers/2024/10/14/nova-filepond-4Gpuh6.jpg"),
            contentDescription = "Article Image",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Уютная минималистичная игра Everholm в традициях Stardew Valley выйдет в ноябре. Доступна демоверсия", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Уютная минималистичная игра Everholm в традициях Stardew Valley выйдет в ноябре. Доступна демоверсия")

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            TextButton(onClick = { likeCount++ }) {
                Text("Like ($likeCount)")
            }
            TextButton(onClick = { dislikeCount++ }) {
                Text("Dislike ($dislikeCount)")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            // Share the text functionality
        }) {
            Text("Share")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            val intent = Intent(context, SecondActivity::class.java) // Создаем намерение
            context.startActivity(intent) // Запускаем вторую активность
        }) {
            Text("Go to second article") // Текст на кнопке
        }
    }
}