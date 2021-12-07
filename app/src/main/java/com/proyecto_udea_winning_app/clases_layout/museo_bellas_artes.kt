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


class museo_bellas_artes : AppCompatActivity() {

    lateinit var detailsViewModel: DetailsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.museo_bellas_artes)

        val button_museo_bellas_artes = findViewById<Button>(R.id.button_museo_bellas_artes)

        button_museo_bellas_artes.setOnClickListener {
            val IntentUri = Uri.parse("geo:37.392563000,-5.999706300?z=17")
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


            text_title = findViewById(R.id.textView_museo_bellas_artes1)
            text_imagen = findViewById(R.id.imageView_museo_bellas_artes)
            text_detail = findViewById(R.id.textView_museo_bellas_artes3)
            text_ubicacion = findViewById(R.id.textView_museo_bellas_artes5)
            text_temperatura = findViewById(R.id.textView_museo_bellas_artes7)
            text_sitios_recomendado = findViewById(R.id.textView_museo_bellas_artes9)


            text_title.text = it.get(5).titles
            Glide.with(baseContext).load(it.get(5).images).into(text_imagen)
            text_detail.text = it.get(5).details
            text_ubicacion.text = it.get(5).ubicacion
            text_temperatura.text = it.get(5).temperatura
            text_sitios_recomendado.text = it.get(5).sitios_recomendados




        })
    }

}
