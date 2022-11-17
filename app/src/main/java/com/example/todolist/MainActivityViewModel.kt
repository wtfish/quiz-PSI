package com.example.todolist

import androidx.lifecycle.ViewModel

class MainActivityViewModel(private val todoRepository: TodoRepository):ViewModel() {
    fun getTodo()=todoRepository.getTodo()
    fun addTodo(todo:TodoModel)=todoRepository.addTodo(todo)

}