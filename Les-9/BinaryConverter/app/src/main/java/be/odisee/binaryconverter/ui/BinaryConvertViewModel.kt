package be.odisee.binaryconverter.ui

import androidx.lifecycle.ViewModel
import be.odisee.binaryconverter.MainActivity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class BinaryConvertViewModel : ViewModel() {
    /*var decimalString = mutableStateOf("")
        private set*/
    private val _uiState = MutableStateFlow(BinaryUiState())
    val uiState = _uiState.asStateFlow()

    fun updateDecimalString(text: String) {
        _uiState.update {
            it.copy(decimalString = text, hasError = text.toLongOrNull() == null)
        }
    }

    fun onConvertClicked() {
        _uiState.update {
            it.copy(binaryString = it.decimalString.toInt().toString(2))
        }
    }

}