package com.example.covid_19

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethod
import android.view.inputmethod.InputMethodManager
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btn_click_me = findViewById(R.id.imageButton) as ImageButton
        var contador = 0
        // set on-click listener
        btn_click_me.setOnClickListener {
            if (contador == 0){
                addNickName(it)
                contador++
            }else if (contador == 1){
                addNickName2(it)
                contador--
            }

        }

    }
    private fun addNickName (view: View){
        var editText = findViewById<EditText>(R.id.nombreText)
        val nicknameTextView = findViewById<TextView>(R.id.textNombre)
        var editText2 = findViewById<EditText>(R.id.edadText)
        val nicknameTextView2 = findViewById<TextView>(R.id.textEdad)
        val textoView = findViewById<TextView>(R.id.mensajeView)
        nicknameTextView.text = editText.text
        nicknameTextView2.text = editText2.text
        var edad = -2
        if (edadText.text.toString().isNotEmpty()){
            val edad = edadText.text.toString().toInt()
        }
        val mensaje = when (edad) {
            in 65..111 -> "Las probabilidades de que contraiga la enfermedad son altas, recomendamos que se cuide"
            in 0..3 -> "Las probabilidades de que contraiga la enfermedad son altas, recomendamos que se cuide"
            in 4..64 -> "Las probabilidades de que contraiga la enfermedad son bajas, pero recomendamos que sea cuidadoso a la hora de salir a la calle"
            in 112 ..Int.MAX_VALUE -> "Ingrese su verdadera edad"
            in Int.MIN_VALUE..-1 -> "Ingrese su verdadera edad"
            else -> "Ingrese su verdadera edad"
        }
        textoView.text = "Hola ${editText.text}, $mensaje"
        textoView.visibility = View.VISIBLE
        editText.visibility = View.INVISIBLE
        nicknameTextView.visibility = View.VISIBLE
        editText2.visibility = View.INVISIBLE
        nicknameTextView2.visibility = View.VISIBLE
        //Escondiendo la entrada de texto
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
    private fun addNickName2 (view: View){
        var editText = findViewById<EditText>(R.id.nombreText)
        val nicknameTextView = findViewById<TextView>(R.id.textNombre)
        var editText2 = findViewById<EditText>(R.id.edadText)
        val nicknameTextView2 = findViewById<TextView>(R.id.textEdad)
        val textoView = findViewById<TextView>(R.id.mensajeView)
        nicknameTextView.text = editText.text
        nicknameTextView2.text = editText2.text
        editText.visibility = View.VISIBLE
        textoView.visibility = View.INVISIBLE
        nicknameTextView.visibility = View.INVISIBLE
        editText2.visibility = View.VISIBLE
        nicknameTextView2.visibility = View.INVISIBLE
        //Escondiendo la entrada de texto
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
