package com.proyecto_udea_winning_app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        val button_museo_bellas_artes = findViewById<Button>(R.id.button_museo_bellas_artes)

        button_museo_bellas_artes.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:37.392563000,-5.999706300")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)


        }
    }
}