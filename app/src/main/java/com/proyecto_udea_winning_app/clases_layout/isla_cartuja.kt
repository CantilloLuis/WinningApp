package com.proyecto_udea_winning_app.clases_layout

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.proyecto_udea_winning_app.R
import com.proyecto_udea_winning_app.conexion_retrofit_detalle_POI.DetailsViewModel


class isla_cartuja : AppCompatActivity() {

    lateinit var detailsViewModel: DetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.isla_cartuja)

        val button_isla_cartuja = findViewById<Button>(R.id.button_isla_cartuja)

        button_isla_cartuja.setOnClickListener {
            val IntentUri = Uri.parse("geo:37.4061,-6.00611")
            val MapIntent = Intent(Intent.ACTION_VIEW, IntentUri)
            MapIntent.setPackage("com.google.android.apps.maps")
            startActivity(MapIntent)


        }
        detailsViewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
        detailsViewModel.getMyData()

        detailsViewModel.onSitiosTuristicosLoad_InterfaceDetalle.observe(this, Observer {

            var text_title: TextView
            var text_imagen: ImageView
            var text_detail: TextView
            var text_ubicacion: TextView
            var text_temperatura: TextView
            var text_sitios_recomendado: TextView


            text_title = findViewById(R.id.textView_isla_cartuja1)
            text_imagen = findViewById(R.id.imageView_isla_cartuja)
            text_detail = findViewById(R.id.textView_isla_cartuja3)
            text_ubicacion = findViewById(R.id.textView_isla_cartuja5)
            text_temperatura = findViewById(R.id.textView_isla_cartuja7)
            text_sitios_recomendado = findViewById(R.id.textView_isla_cartuja9)


            text_title.text = it.get(9).titles
            Glide.with(baseContext).load(it.get(9).images).into(text_imagen)
            text_detail.text = it.get(9).details
            text_ubicacion.text = it.get(9).ubicacion
            text_temperatura.text = it.get(9).temperatura
            text_sitios_recomendado.text = it.get(9).sitios_recomendados




        })


    }

}