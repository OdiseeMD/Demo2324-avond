package be.odisee.colors

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import be.odisee.colors.data.DataSource
import be.odisee.colors.model.HTMLColor
import be.odisee.colors.ui.theme.ColorsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ColorsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ColorGrid()
                }
            }
        }
    }
}

@Composable
fun ColorGrid(modifier: Modifier = Modifier) {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(DataSource.getColors()) {
            ColorCard(color = it, modifier = Modifier.padding(8.dp), isGrid = true)
        }
    }
}


@Composable
fun ColorList(modifier: Modifier = Modifier) {
    LazyColumn {
        items(DataSource.getColors()) {
            ColorCard(color = it, modifier = Modifier.padding(8.dp))
        }
    }
}

@Composable
fun ColorCard(color: HTMLColor, modifier: Modifier = Modifier, isGrid: Boolean = false) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = color.backgroundColor,
            contentColor = color.contrastColor
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = modifier
    ) {
        if (isGrid) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(color.name)
                Text("#${color.hexCode.toString(16)}")
            }
        } else {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(color.name)
                Text("#${color.hexCode.toString(16)}")
            }
        }

    }
}


@Preview(showBackground = true)
@Composable
fun ColorCardPreview() {
    ColorsTheme {
        ColorCard(color = DataSource.getColors().first(), modifier = Modifier.fillMaxWidth())
    }
}

@Preview(showSystemUi = true)
@Composable
fun ColorListPreview() {
    ColorsTheme {
        ColorList()
    }
}

@Preview(showSystemUi = true)
@Composable
fun ColorGridPreview() {
    ColorsTheme {
        ColorGrid()
    }
}