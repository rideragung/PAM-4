package com.example.pampum

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var editText1: EditText
    private lateinit var editText2: EditText
    private lateinit var radioGroup: RadioGroup
    private lateinit var buttonCalculate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        editText1 = findViewById(R.id.editText1)
        editText2 = findViewById(R.id.editText2)
        radioGroup = findViewById(R.id.radioGroup)
        buttonCalculate = findViewById(R.id.buttonCalculate)

        buttonCalculate.setOnClickListener {
            calculate()
        }
    }

    private fun calculate() {
        val num1 = editText1.text.toString().toDoubleOrNull()
        val num2 = editText2.text.toString().toDoubleOrNull()

        if (num1 == null || num2 == null) {
            Toast.makeText(this, "Please enter valid numbers", Toast.LENGTH_SHORT).show()
            return
        }

        val result = when (radioGroup.checkedRadioButtonId) {
            R.id.radioAdd -> num1 + num2
            R.id.radioSubtract -> num1 - num2
            R.id.radioMultiply -> num1 * num2
            R.id.radioDivide -> {
                if (num2 != 0.0) num1 / num2 else {
                    Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                    return
                }
            }
            else -> {
                Toast.makeText(this, "Please select an operation", Toast.LENGTH_SHORT).show()
                return
            }
        }

        val intent = Intent(this, HasilActivity::class.java).apply {
            putExtra("RESULT", result)
            putExtra("NIM", "225150400111050")
            putExtra("NAME", "Bangkit Agung Laksono")
        }
        startActivity(intent)
    }
}