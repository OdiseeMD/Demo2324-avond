package be.odisee.todo.ui.addscreen

sealed interface CreateTodoApiStatus {
    object Init : CreateTodoApiStatus
    object Loading : CreateTodoApiStatus
    data class Error(val errorMessage: String) : CreateTodoApiStatus
    object Success : CreateTodoApiStatus
}

data class AddState(
    val title: String = "",
    val description: String = "",
    val dueDate: String = "",
    val apiStatus: CreateTodoApiStatus = CreateTodoApiStatus.Init
)
