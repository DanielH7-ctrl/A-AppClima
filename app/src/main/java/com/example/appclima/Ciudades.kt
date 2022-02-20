package com.example.appclima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class Ciudades : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudades)

        val bfcp = findViewById<Button>(R.id.bfcp)
        val btul = findViewById<Button>(R.id.btul)
        val bcan = findViewById<Button>(R.id.bcan)
        val bpla = findViewById<Button>(R.id.bpla)

        bfcp.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Felipe Carrillo Puerto", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
        btul.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Tulum", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
        bcan.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Cancun", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
        bpla.setOnClickListener(View.OnClickListener {
            Toast.makeText(this, "Playa Del Carmen", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        })
    }
}