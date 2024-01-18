package be.odisee.eightball

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.odisee.eightball.ui.theme.EightballTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EightballTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    EightBallButton()
                }
            }
        }
    }
}

@Composable
fun EightBallButton(modifier: Modifier = Modifier) {
    var random by remember {
        mutableStateOf(-1)
    }


    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        EightBall(random)
        Button(
            onClick = {
                random = (0..19).random()
            },
            enabled = false,
            modifier = Modifier.padding(top = 8.dp),
        ) {
            Text(text = stringResource(R.string.get_answer))
        }
    }
}

@Composable
fun EightBall(randomValue: Int, modifier: Modifier = Modifier) {

    val id = when (randomValue) {
        0 -> R.string.result_1
        1 -> R.string.result_2
        2 -> R.string.result_3
        3 -> R.string.result_4
        4 -> R.string.result_5
        5 -> R.string.result_6
        6 -> R.string.result_7
        7 -> R.string.result_8
        8 -> R.string.result_9
        9 -> R.string.result_10
        10 -> R.string.result_11
        11 -> R.string.result_12
        12 -> R.string.result_13
        13 -> R.string.result_14
        14 -> R.string.result_15
        15 -> R.string.result_16
        16 -> R.string.result_17
        17 -> R.string.result_18
        18 -> R.string.result_19
        19 -> R.string.result_20
        else -> null
    }

    var text = ""
    if (id != null) {
        text = stringResource(id = id)
    }


    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.bal),
            contentDescription = null
        )
        Text(
            text = text,
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .padding(8.dp),
            textAlign = TextAlign.Center
        )
    }

}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EightBallButtonPreview() {
    EightballTheme {
        EightBallButton()
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EightBallPreview() {
    EightballTheme {
        EightBall(14)
    }
}