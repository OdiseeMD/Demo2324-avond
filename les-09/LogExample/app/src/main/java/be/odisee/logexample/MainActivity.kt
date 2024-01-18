package be.odisee.logexample

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import be.odisee.logexample.ui.theme.LogExampleTheme

const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LogExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var text by remember {
        mutableStateOf("")
    }
    Column {
        TextField(value = text,
            onValueChange = {
                text = it

                Log.d(TAG, "text updated to $it")
            })


        val number = text.toLongOrNull() ?: 0

        Text(text = number.toString())
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LogExampleTheme {
        Greeting("Android")
    }
}