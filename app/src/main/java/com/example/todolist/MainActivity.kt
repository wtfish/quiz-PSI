package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var counter:Int=1;
        this.setTitle("todolist")
        setContentView(R.layout.activity_main)
        val factory=InjectorUtils.provideTodoViewModelFactory()
        val textviewMhs:TextView=findViewById<TextView>(R.id.mahasiswa)
        val fieldDeskripsi:EditText=findViewById<EditText>(R.id.editTextDeskripsi)
        val viewModel=ViewModelProvider(this,factory).get(MainActivityViewModel::class.java)
        viewModel.getTodo().observe(this,Observer{ mahasiswas->
             val stringBuilder=StringBuilder()
            mahasiswas.forEach { mahasiswa->
                stringBuilder.append("$mahasiswa\n\n")
            }
            textviewMhs.text=stringBuilder.toString()
        })
        findViewById<Button>(R.id.tambah).setOnClickListener{
            val mhs=TodoModel(counter++,fieldDeskripsi.text.toString())
            viewModel.addTodo(mhs)
            fieldDeskripsi.setText("")
        }
    }
}