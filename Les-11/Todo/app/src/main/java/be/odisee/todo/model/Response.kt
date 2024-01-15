package be.odisee.todo.model

import kotlinx.serialization.Serializable

@Serializable
data class TodoListResponse(val status: String, val message: List<Todo>)

@Serializable
data class StringResponse(val status: String, val message: String)