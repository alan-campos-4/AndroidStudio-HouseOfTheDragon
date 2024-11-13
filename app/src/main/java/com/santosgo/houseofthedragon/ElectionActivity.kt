package com.santosgo.houseofthedragon

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class ElectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_election)
        /*
        enableEdgeToEdge()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/

        //obtener una referencia a la etiqueta de la actividad
        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)

        //recogemos el nombre del intent
        val nombre = intent.getStringExtra("NAME")
        //creamos la cadena del saludo
        tvGreeting.apply {
            //toma el valor de la cadena "greeting" y le incorpora el valor del nombre.
            text = getString(R.string.greeting,nombre)
        }
    }
}