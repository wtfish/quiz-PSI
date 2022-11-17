package com.example.todolist
data class TodoModel (val nomer:Int, val deskripsi:String){
    override fun toString(): String {
        return "${nomer.toString()} - $deskripsi"
    }

}