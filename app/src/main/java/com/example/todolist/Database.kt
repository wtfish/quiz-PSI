package com.example.todolist

class Database private  constructor(){
    var TodoDao=TodoDao()
    private set
    // buat singleton
    companion object{
        @Volatile private var instance: Database?=null
        fun getInstance()=
            instance?: synchronized(this){
                instance ?: Database().also {instance=it}

        }
    }
}