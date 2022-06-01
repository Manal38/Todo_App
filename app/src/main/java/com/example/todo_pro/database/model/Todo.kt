package com.example.todo_pro.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity
data class Todo(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo
    val id: Int? = null,
    @ColumnInfo
    val name: String? = null,
    @ColumnInfo
    val details: String? = null,
    @ColumnInfo
    val date: Date? = null,
    @ColumnInfo
    val isDone: Boolean? = false
)