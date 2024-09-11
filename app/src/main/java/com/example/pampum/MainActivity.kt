package com.example.pampum

import android.content.Intent
import android.os.Bundle
import android.widget.*
import android.view.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var editTextResult: EditText
    private var currentNumber = ""
    private var firstNumber = 0.0
    private var operation = ""
    private var lastResult = 0.0
    private var isNewOperation = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextResult = findViewById(R.id.editTextResult)

        // Number buttons
        val numberButtons = arrayOf(
            R.id.button0, R.id.button1, R.id.button2, R.id.button3, R.id.button4,
            R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9
        )
        for (buttonId in numberButtons) {
            findViewById<Button>(buttonId).setOnClickListener { numberClick(it as Button) }
        }

        // Operation buttons
        findViewById<Button>(R.id.buttonPlus).setOnClickListener { operationClick("+") }
        findViewById<Button>(R.id.buttonMinus).setOnClickListener { operationClick("-") }
        findViewById<Button>(R.id.buttonMultiply).setOnClickListener { operationClick("*") }
        findViewById<Button>(R.id.buttonDivide).setOnClickListener { operationClick("/") }

        // Equals button
        findViewById<Button>(R.id.buttonEquals).setOnClickListener { calculateResult() }

        // Clear button
        findViewById<Button>(R.id.buttonClear).setOnClickListener { clearCalculator() }
    }

    private fun numberClick(button: Button) {
        if (isNewOperation) {
            currentNumber = ""
            isNewOperation = false
        }
        currentNumber += button.text
        editTextResult.setText(currentNumber)
    }

    private fun operationClick(op: String) {
        if (currentNumber.isNotEmpty()) {
            if (operation.isNotEmpty()) {
                calculateResult()
            }
            firstNumber = currentNumber.toDouble()
            currentNumber = ""
            operation = op
            isNewOperation = true
        } else if (lastResult != 0.0) {
            firstNumber = lastResult
            operation = op
            isNewOperation = true
        }
    }

    private fun calculateResult() {
        if (currentNumber.isNotEmpty() && operation.isNotEmpty()) {
            val secondNumber = currentNumber.toDouble()
            val result = when (operation) {
                "+" -> firstNumber + secondNumber
                "-" -> firstNumber - secondNumber
                "*" -> firstNumber * secondNumber
                "/" -> if (secondNumber != 0.0) firstNumber / secondNumber else Double.NaN
                else -> Double.NaN
            }
            editTextResult.setText(result.toString())
            lastResult = result
            currentNumber = result.toString()
            operation = ""
            isNewOperation = true
        }
    }

    private fun clearCalculator() {
        currentNumber = ""
        firstNumber = 0.0
        lastResult = 0.0
        operation = ""
        isNewOperation = true
        editTextResult.setText("")
    }
}