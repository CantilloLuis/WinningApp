package com.proyecto_udea_winning_app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity10 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main10)

        val button_plaza_toros = findViewById<Button>(R.id.button_plaza_toros)

        button_plaza_toros.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:37.385959,-5.998407?z=18")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)


        }
    }
}