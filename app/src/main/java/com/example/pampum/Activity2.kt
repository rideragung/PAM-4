package com.example.pampum

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class Activity2 : AppCompatActivity() {
    private lateinit var tvNim: TextView
    private lateinit var tvNama: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2)

        tvNim = findViewById(R.id.tvNim2)
        tvNama = findViewById(R.id.tvNama2)

        val nim = intent.getStringExtra("nim")
        val name = intent.getStringExtra("name")

        tvNim.text = "NIM : $nim"
        tvNama.text = "Nama : $name"
    }
}