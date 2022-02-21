package com.example.appclima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var tvCiudad:TextView? = null
    var tvGrados:TextView? = null
    var tvEstatus:TextView? = null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvCiudad = findViewById(R.id.tvCiudad)
        tvGrados = findViewById(R.id.tvGrados)
        tvEstatus = findViewById(R.id.tvEstatus)

        val ciudad = intent.getStringExtra("com.example.appclima.ciudades.CIUDAD")
        Toast.makeText(this, ciudad, Toast.LENGTH_SHORT).show()

        val ciudadfcp = Ciudad("Felipe Carrillo Puerto", 27, "Soleado")
        val ciudadtul = Ciudad("Tulum", 24, "Soleado")
        val ciudadcan = Ciudad("Cancun", 26, "Nublado")
        val ciudadpla = Ciudad("Playa Del Carmen", 25, "Nublado")

        when (ciudad) {
            "ciudad-felipecarrillopuerto" -> {
                tvCiudad?.text = ciudadfcp.nombre
                tvGrados?.text = ciudadfcp.grados.toString() + "°"
                tvEstatus?.text = ciudadfcp.estatus
            }
            "ciudad-tulum" -> {
                tvCiudad?.text = ciudadtul.nombre
                tvGrados?.text = ciudadtul.grados.toString() + "°"
                tvEstatus?.text = ciudadtul.estatus
            }
            "ciudad-cancun" -> {
                tvCiudad?.text = ciudadcan.nombre
                tvGrados?.text = ciudadcan.grados.toString() + "°"
                tvEstatus?.text = ciudadcan.estatus
            }
            "ciudad-playadelcarmen" -> {
                tvCiudad?.text = ciudadpla.nombre
                tvGrados?.text = ciudadpla.grados.toString() + "°"
                tvEstatus?.text = ciudadpla.estatus
            }
        }


    }
}