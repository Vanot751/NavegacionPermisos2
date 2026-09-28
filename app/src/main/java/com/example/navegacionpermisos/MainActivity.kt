package com.example.navegacionpermisos

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

//Importaciones para hacer funcionar el codigo
import android.widget.Button
import android.widget.EditText
import android.util.Log
import android.content.Intent



class MainActivity : AppCompatActivity() {

    private lateinit var etTexto: EditText
    private lateinit var btnEnviar: Button
    private lateinit var btnPermiso: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    Log.d("MainActivity","onCreate ejecutado")
    initViews()
    setupListeners()

    }

    override fun onStart(){
        super.onStart()
        Log.d("MainActivity","onStart ejecutado")
    }

    private fun initViews() {
        etTexto = findViewById(R.id.etTexto)
        btnEnviar = findViewById(R.id.btnEnviar)
        btnPermiso = findViewById(R.id.btnPermiso)
    }

    private fun setupListeners() {
        btnEnviar.setOnClickListener {
            val textoEnviado = etTexto.text.toString()

            if (textoEnviado.isNotEmpty()) {
                val intent = Intent(this, DetalleActivity::class.java)
                intent.putExtra("DATO_ENVIADO", textoEnviado)
                startActivity(intent)
            } else {
                // Mostrar mensaje si está vacío
                etTexto.error = "Ingresa un texto"
            }
        }
    }

}