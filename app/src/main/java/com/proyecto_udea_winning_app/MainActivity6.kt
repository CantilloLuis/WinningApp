package com.proyecto_udea_winning_app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        val button_parque_maria_luisa = findViewById<Button>(R.id.button_parque_maria_luisa)

        button_parque_maria_luisa.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:37.374973000,-5.988886000?z=15")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)


        }
    }
}