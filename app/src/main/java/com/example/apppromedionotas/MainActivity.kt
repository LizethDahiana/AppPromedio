package com.example.apppromedionotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import android.graphics.Color
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonCalcular:Button=findViewById(R.id.btnCalcular)
        botonCalcular.setOnClickListener { realizarCalculo() }
    }

    private fun realizarCalculo() {

        val campoNombre:EditText=findViewById(R.id.idNombreTxt)
        val campoNota1:EditText=findViewById(R.id.idNota1Txt)
        val campoNota2:EditText=findViewById(R.id.idNota2Txt)
        val campoNota3:EditText=findViewById(R.id.idNota3Txt)
        val mensajeResult:TextView=findViewById(R.id.txtResultado)


        val nombre:String=campoNombre.text.toString()
        val nota1:Double=campoNota1.text.toString().toDouble()
        val nota2:Double=campoNota2.text.toString().toDouble()
        val nota3:Double=campoNota3.text.toString().toDouble()

        val colorGano = "#00FF00"
        val colorPerdio = "#FF0000"
        val colorResultado: Int

        var prom:Double=(nota1+nota2+nota3)/3
        println("El promedio es: "+prom)
        Log.i("salida", "El promedio es $prom")

        var result=""


        if (prom>=3.5){
            Log.i("salida", "Ganó con promedio de $prom")
            result="$nombre ganó con promedio de $prom"
            colorResultado = Color.parseColor(colorGano)
        }else{
            Log.i("salida", "perdió con promedio de $prom")
            result="$nombre perdió con promedio de $prom"
            colorResultado = Color.parseColor(colorPerdio)
        }

        mensajeResult.text = "Hola $nombre usted $result"
        mensajeResult.setTextColor(colorResultado)

        Toast.makeText(this, result,Toast.LENGTH_LONG).show()
    }
}