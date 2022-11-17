package com.example.todolist

object InjectorUtils {
    fun provideTodoViewModelFactory():MainActivityFactory{
        val todoRepository=TodoRepository.getInstance(Database.getInstance().TodoDao)
        return MainActivityFactory(todoRepository)
    }
}