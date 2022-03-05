package com.example.appclima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import java.net.URL

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

        if(Network.isNetworkAvailable(this)){
            //EJECUTAR SOLICITUD HTTP
            solicitudHTTPVolley("http://api.openweathermap.org/data/2.5/weather?id="+ciudad+"&appid=a0bb28f0216d0f9427c2ea0e58fe124c&units=metric&lang=es")
            //a0bb28f0216d0f9427c2ea0e58fe124c
            //Felipe Carrillo Puerto 3527639
        }else {
            //MOSTRAR MENSAJE DE ERROR
        }
        /*
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
        }*/
    }
    private fun solicitudHTTPVolley(url: String) {
        val queue = Volley.newRequestQueue(this)

        val solicitud = StringRequest(Request.Method.GET, url, {
                response ->
            try {
                Log.d( "solicitudHTTPVolley", response)

                val gson = Gson()
                val ciudad = gson.fromJson(response, Ciudad::class.java)
                tvCiudad?.text = ciudad.name
                tvGrados?.text= ciudad.main?.temp.toString() + "°"
                tvEstatus?.text=ciudad.weather?.get(0)?.description
            } catch (e: Exception) {
            }
        }, {})
        queue.add(solicitud)
    }

}