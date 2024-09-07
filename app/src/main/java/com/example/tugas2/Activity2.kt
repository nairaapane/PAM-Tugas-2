package com.example.tugas2

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val result = intent.getDoubleExtra("RESULT", 0.0)
        val nama = intent.getStringExtra("NAMA")
        val nim = intent.getStringExtra("NIM")

        val hasil = findViewById<TextView>(R.id.tvHasil)
        val infoNama = findViewById<TextView>(R.id.tvNama)
        val infoNim = findViewById<TextView>(R.id.tvNIM)

        hasil.text = "$result"
        infoNama.text = "Nama: $nama"
        infoNim.text = "NIM: $nim"
    }
}