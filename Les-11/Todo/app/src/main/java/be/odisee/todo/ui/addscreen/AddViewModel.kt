package be.odisee.todo.ui.addscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import be.odisee.todo.model.StringResponse
import be.odisee.todo.model.Todo
import be.odisee.todo.network.TodoApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import retrofit2.HttpException
import java.util.UUID

const val TAG = "AddViewModel"

class AddViewModel : ViewModel() {

    private val _state = MutableStateFlow(AddState())
    val state = _state.asStateFlow()

    fun onTitleChanged(title: String) {
        _state.update {
            it.copy(title = title)
        }
    }

    fun onDescriptionChanged(description: String) {
        _state.update {
            it.copy(description = description)
        }
    }

    fun onDueDateChanged(dueDate: String) {
        _state.update {
            it.copy(dueDate = dueDate)
        }
    }

    fun addItem() {
        _state.update {
            it.copy(apiStatus = CreateTodoApiStatus.Loading)
        }
        viewModelScope.launch {
            try {

                val item = Todo(
                    id = UUID.randomUUID().toString(),
                    title = state.value.title,
                    description = state.value.description
                )
                if (state.value.dueDate.isNotBlank()) {
                    item.dueDate = state.value.dueDate
                }

                val response = TodoApi.retrofitService.addItem(item)
                _state.update {
                    it.copy(apiStatus = CreateTodoApiStatus.Success)
                }
                Log.d(TAG, response.toString())
            } catch (ex: HttpException) {
                Log.d(TAG, ex.message.toString())

                val response = ex.response()?.errorBody()?.string()
                    ?.let { Json.decodeFromString<StringResponse>(it) }
                _state.update {
                    it.copy(
                        apiStatus = CreateTodoApiStatus.Error(
                            response?.message ?: "unknown Error"
                        )
                    )
                }

            } catch (ex: Exception) {
                Log.d(TAG, ex.message.toString())
                _state.update {
                    it.copy(apiStatus = CreateTodoApiStatus.Error("unknown Error"))
                }
            }
        }
    }
}
