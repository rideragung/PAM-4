package com.example.pampum

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var editTextName: EditText
    private lateinit var editTextNim: EditText
    private lateinit var buttonAdd: Button
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: StudentAdapter
    private val studentList = mutableListOf<Student>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextName = findViewById(R.id.editTextName)
        editTextNim = findViewById(R.id.editTextNim)
        buttonAdd = findViewById(R.id.buttonAdd)
        recyclerView = findViewById(R.id.recyclerView)

        adapter = StudentAdapter(studentList) { student ->
            val intent = Intent(this, Activity2::class.java)
            intent.putExtra("nim", student.nim)
            intent.putExtra("name", student.name)
            startActivity(intent)
        }

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        buttonAdd.setOnClickListener {
            val name = editTextName.text.toString()
            val nim = editTextNim.text.toString()
            if (name.isNotEmpty() && nim.isNotEmpty()) {
                val student = Student(nim, name)
                studentList.add(student)
                adapter.notifyItemInserted(studentList.size - 1)
                editTextName.text.clear()
                editTextNim.text.clear()
            }
        }
    }
}