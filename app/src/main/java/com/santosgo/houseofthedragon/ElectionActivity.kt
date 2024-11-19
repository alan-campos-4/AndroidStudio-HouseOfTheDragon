package com.santosgo.houseofthedragon

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView

class ElectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_election)

        //Recogemos el nombre del intent
        val nombre = intent.getStringExtra("NAME")

        //Aplica el valor del intent, el nombre, al TextView.
        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)
        tvGreeting.apply { text = getString(R.string.greeting, nombre) }

        //Variable es true si la seleccion de los checkboxes es correcta
        var isSelectionValid:Boolean = false

        //Listener del botón de acceso a la siguiente actividad
        val btnAnswer = findViewById<Button>(R.id.btnChoose)
        btnAnswer.setOnClickListener{
            goToResult(isSelectionValid)
        }

        //Listeneres de los checkboxes
        val checked1 = findViewById<CheckBox>(R.id.checkboxRaenria)
        val checked2 = findViewById<CheckBox>(R.id.checkboxAegon)
        checked1.setOnCheckedChangeListener{
            buttonView, isChecked ->
            isSelectionValid = changeResult()
        }
        checked2.setOnCheckedChangeListener{
            buttonView, isChecked ->
            isSelectionValid = changeResult()
        }
    }

    //Devuelve si la selección de checkboxes es correcta y muestra un mensaje si no.
    fun changeResult():Boolean
    {
        val checkedRaenria = findViewById<CheckBox>(R.id.checkboxRaenria).isChecked
        val checkedAegon = findViewById<CheckBox>(R.id.checkboxAegon).isChecked
        val resultMessage = findViewById<TextView>(R.id.tvReminder)

        if (checkedRaenria && checkedAegon)
        {
            resultMessage.text = getString(R.string.ChoseBoth)
            return false
        }
        else if (!checkedRaenria && !checkedAegon)
        {
            resultMessage.text = getString(R.string.ChoseNone)
            return false
        }
        else
        {
            resultMessage.text = ""
            return true
        }
    }

    //Accede a la siguiente actividad si la selección es válida.
    fun goToResult(valid:Boolean)
    {
        if (valid)
        {
            //Crea el intent
            val intent = Intent(this@ElectionActivity, ResultsActivity::class.java)
            //Comprueba cual checkbox se ha marcado
            val checked1 = findViewById<CheckBox>(R.id.checkboxRaenria).isChecked

            //Crea el intent según el mensaje y lo lanza
            if (checked1)
                intent.putExtra("RESULT", getString(R.string.Chose1))
            else
                intent.putExtra("RESULT", getString(R.string.Chose2))
            startActivity(intent)
        }
        else
            changeResult()
    }
}