package com.example.todo_pro

import java.util.*

fun Calendar.clearTime(): Calendar {
    this.clear(Calendar.SECOND)
    this.clear(Calendar.MINUTE)
    this.clear(Calendar.MILLISECOND)
    this.clear(Calendar.HOUR)
    return this
}