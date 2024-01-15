package be.odisee.todo.ui.overview

import be.odisee.todo.model.Todo

sealed interface TodoListApiStatus {
    object Loading : TodoListApiStatus
    data class Success(val items: List<Todo>) : TodoListApiStatus
    object Error : TodoListApiStatus
}

data class OverViewUiState(val apiStatus: TodoListApiStatus = TodoListApiStatus.Loading)

