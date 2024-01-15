package be.odisee.todo.ui.overview

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import be.odisee.todo.network.TodoApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

const val TAG = "OverviewViewModel"

class OverviewViewModel : ViewModel() {

    private val _state = MutableStateFlow(OverViewUiState())
    val state = _state.asStateFlow()

    init {
        reload()
    }

    fun reload() {
        viewModelScope.launch {
            try {
                val response = TodoApi.retrofitService.getTodos()
                _state.update {
                    it.copy(apiStatus = TodoListApiStatus.Success(response.message))
                }
                Log.d(TAG, response.toString())
            } catch (ex: Exception) {
                Log.w(TAG, ex.message.toString())
                _state.update {
                    it.copy(apiStatus = TodoListApiStatus.Error)
                }
            }
        }
    }


    fun check(id: String, value: Boolean) {
        viewModelScope.launch {
            if (value) {
                TodoApi.retrofitService.checkTodo(id)
            } else {
                TodoApi.retrofitService.uncheckTodo(id)
            }
            reload()
        }
    }
}
