package com.codelab.basics

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.codelab.basics.ui.theme.BasicsCodelabTheme
import com.codelab.basics.ui.theme.Yellow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicsCodelabTheme {
                FlyingApp(modifier = Modifier.fillMaxSize())
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    var expended = false
    val onClick = {
        expended = !expended
    }
    //suface로 뎁스를 추가할수도 있고 직접 배경색을 줄수도 있다...
    Surface(color = MaterialTheme.colors.primary, modifier = Modifier.padding(8.dp)) {
        Row(modifier = Modifier.padding(24.dp)) {
            Column(modifier = Modifier
                .padding(10.dp)
                .weight(1f)) {
                Text(text = "sleepy...", Modifier.fillMaxWidth())
                Text(text = "isn't you, $name?", Modifier.fillMaxWidth())
            }
            Button(onClick = onClick, Modifier.background(Yellow).border(BorderStroke(1.dp, Color.Red))) {
                Text(if(expended)"show less" else "show more")
            }
        }

    }

}

@Composable
private fun FlyingApp(
    modifier: Modifier = Modifier,
    names: List<String> = listOf<String>("hsyoo", "flyingyoo")
) {
    Column(modifier = modifier.padding(4.dp)) {
        for(name in names) {
            Greeting(name = name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BasicsCodelabTheme {
        Greeting("Android")
    }
}

@Preview(showBackground = true, widthDp = 320)
@Composable
fun CustomPreview() {
    BasicsCodelabTheme {
        FlyingApp()
    }
}