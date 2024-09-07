package com.example.tugas2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val in1 = findViewById<EditText>(R.id.in1)
        val in2 = findViewById<EditText>(R.id.in2)
        val rgGroup = findViewById<RadioGroup>(R.id.rgGroup)
        val btn1 = findViewById<Button>(R.id.btn1)

        btn1.setOnClickListener {
            val firstNumber = in1.text.toString()
            val secondNumber = in2.text.toString()

            if (firstNumber.isEmpty() || secondNumber.isEmpty()) {
                Toast.makeText(this, "Masukkan kedua angka", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val num1 = firstNumber.toDouble()
            val num2 = secondNumber.toDouble()

            val selectedOperationId = rgGroup.checkedRadioButtonId
            if (selectedOperationId == -1) {
                Toast.makeText(this, "Pilih operasi", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val operation = findViewById<RadioButton>(selectedOperationId)
            val result = when (operation.text) {
                "+" -> num1 + num2
                "-" -> num1 - num2
                "*" -> num1 * num2
                "/" -> if (num2 != 0.0) num1 / num2 else Double.NaN
                else -> 0.0
            }

            val intent = Intent(this, Activity2::class.java)
            intent.putExtra("RESULT", result)
            intent.putExtra("NAMA", "Naira Oktarini Pane")
            intent.putExtra("NIM", "225150407111040")
            startActivity(intent)
        }
    }
}