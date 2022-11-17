package com.example.todolist

class TodoRepository private constructor(private val todoDao:TodoDao) {
    fun addTodo(todo:TodoModel){
        todoDao.addTodo(todo)
    }
    fun getTodo()=todoDao.getTodo()
    companion object{
        @Volatile private var instance: TodoRepository?=null
        fun getInstance(todoDao:TodoDao)=
            instance?: synchronized(this){
                instance ?: TodoRepository(todoDao).also {instance=it}

            }
    }
}