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


class plaza_espana : AppCompatActivity() {

    lateinit var detailsViewModel: DetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.plaza_espana)

        val button_plaza_españa = findViewById<Button>(R.id.button_plaza_españa)

        button_plaza_españa.setOnClickListener {
            val IntentUri = Uri.parse("geo:37.374973000,-5.988886000?z=15")
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


            text_title = findViewById(R.id.textView_plaza_españa1)
            text_imagen = findViewById(R.id.imageView_plaza_españa)
            text_detail = findViewById(R.id.textView_plaza_españa3)
            text_ubicacion = findViewById(R.id.textView_plaza_españa5)
            text_temperatura = findViewById(R.id.textView_plaza_españa7)
            text_sitios_recomendado = findViewById(R.id.textView_plaza_españa9)


            text_title.text = it.get(1).titles
            Glide.with(baseContext).load(it.get(1).images).into(text_imagen)
            text_detail.text = it.get(1).details
            text_ubicacion.text = it.get(1).ubicacion
            text_temperatura.text = it.get(1).temperatura
            text_sitios_recomendado.text = it.get(1).sitios_recomendados



        })


    }

  }

