package be.odisee.todo.network

import be.odisee.todo.model.StringResponse
import be.odisee.todo.model.Todo
import be.odisee.todo.model.TodoListResponse
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

val BASE_URL = "https://odisee-todo.azurewebsites.net"
val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
    .baseUrl(BASE_URL)
    .build()


interface TodoApiService {
    @GET("/todo")
    suspend fun getTodos(): TodoListResponse

    @POST("/todo/{id}/check")
    suspend fun checkTodo(@Path("id") id: String)

    @POST("/todo/{id}/uncheck")
    suspend fun uncheckTodo(@Path("id") id: String)

    @POST("/todo")
    suspend fun addItem(@Body item: Todo): StringResponse
}

object TodoApi {
    val retrofitService by lazy {
        retrofit.create(TodoApiService::class.java)
    }
}