package com.proyecto_udea_winning_app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

       val button_setas_encarnacion = findViewById<Button>(R.id.button_setas_encarnacion)

        button_setas_encarnacion.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:37.393253,-5.991881?z=15")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
                startActivity(mapIntent)


        }
    }
}