package com.example.todolist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class TodoDao{
    private  val listOfTodoModel= mutableListOf<TodoModel>()
    private val Todo=MutableLiveData<List<TodoModel>>()
    init {
        Todo.value=listOfTodoModel
    }
    fun addTodo(mhs: TodoModel){
        listOfTodoModel.add(mhs)
        Todo.value=listOfTodoModel
    }
    fun getTodo() = Todo as LiveData<List<TodoModel>>

}