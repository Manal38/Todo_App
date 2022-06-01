package com.example.todo_pro.database

import androidx.room.*
import com.example.todo_pro.database.model.Todo
import java.util.*

@Dao
interface TodoDao {
    @Insert
    fun addTodo(todo: Todo)

    @Update
    fun updateTodo(todo: Todo)

    @Delete
    fun deleteTodo(todo: Todo)

    @Query("select * from Todo")
    fun getAllTodos(): List<Todo>

    @Query("select * from Todo where date =:date ")
    fun getTodosByDate(date: Date): List<Todo>
}