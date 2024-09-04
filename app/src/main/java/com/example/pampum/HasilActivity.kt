package com.example.pampum

import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HasilActivity : AppCompatActivity() {
        private lateinit var textViewResult: TextView
        private lateinit var textViewNim: TextView
        private lateinit var textViewName: TextView

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_hasil)

            textViewResult = findViewById(R.id.textViewResult)
            textViewNim = findViewById(R.id.textViewNim)
            textViewName = findViewById(R.id.textViewName)

            val result = intent.getDoubleExtra("HASIL", 0.0)
            val nim = intent.getStringExtra("NIM")
            val name = intent.getStringExtra("NAME")

            textViewResult.text = "Hasil: $result"
            textViewNim.text = "NIM: $nim"
            textViewName.text = "Name: $name"
        }
    }