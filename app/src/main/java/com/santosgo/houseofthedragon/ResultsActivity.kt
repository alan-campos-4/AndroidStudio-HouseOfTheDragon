package com.santosgo.houseofthedragon

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.system.exitProcess


class ResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_results)

        //Recogemos el mensaje del intent
        val message = intent.getStringExtra("RESULT")

        //Introduce el valor del mensaje en el texto
        val tvResult = findViewById<TextView>(R.id.tvResult)
        tvResult.apply { text = message }

        //Activa el boton para cerrar la aplicacion
        val btnClose = findViewById<Button>(R.id.btnClose)
        btnClose.setOnClickListener {
            this.finishAffinity()
        }
    }
}