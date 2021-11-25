package com.proyecto_udea_winning_app

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        val button_iglesia_san_luis = findViewById<Button>(R.id.button_iglesia_san_luis)

        button_iglesia_san_luis.setOnClickListener {
            val gmmIntentUri = Uri.parse("geo:37.39838,-5.98831?z=16")
            val mapIntent = Intent(Intent.ACTION_VIEW, gmmIntentUri)
            mapIntent.setPackage("com.google.android.apps.maps")
            startActivity(mapIntent)


        }
    }
}