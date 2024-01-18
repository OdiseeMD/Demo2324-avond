package be.odisee.binaryconverter.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import be.odisee.binaryconverter.R
import be.odisee.binaryconverter.ui.theme.BinaryConverterTheme

@Composable
fun BinaryConverterApp(modifier: Modifier = Modifier) {
    val viewModel: BinaryConvertViewModel = viewModel()
    val state by viewModel.uiState.collectAsState()

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = state.decimalString,
            onValueChange = {
                viewModel.updateDecimalString(it) },
            isError = state.hasError
        )
        Button(
            onClick = { viewModel.onConvertClicked()},
            enabled = !state.hasError
        ) {
            Text(stringResource(R.string.convert))
        }
        Text(text = stringResource(R.string.binaire_text, state.binaryString))
    }
}

@Composable
@Preview(showSystemUi = true)
fun BinaryConverterAppPreview() {
    BinaryConverterTheme {
        BinaryConverterApp()
    }
}