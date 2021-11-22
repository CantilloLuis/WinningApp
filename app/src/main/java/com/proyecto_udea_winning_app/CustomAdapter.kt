package com.proyecto_udea_winning_app

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter: RecyclerView.Adapter<CustomAdapter.ViewHolder>() {


    val titles = arrayOf(
         "Plaza España.",
         "Setas de la Encarnación.",
         "Iglesia san luis de los franceses.",
         "Reales Alcazares.",
         "Parque de María Luisa.",
         "Museo de Bellas Artes.",
         "La Catedral.",
         "La torre de Giralda.",
         "Plaza de toros de la Maestranza.",
         "Isla de la Cartuja.")

    val details = arrayOf(
        "Ubicacion: Estás situado en el parque de María Luisa de la ciudad de Sevilla, España.",
        "Ubicacion: Esta obra está ubicada entre la plaza de la Encarnación y la plaza mayor de Sevilla, España.",
        "Ubicacion: Esta iglesia se encuentra ubicada en el número 27 de la calle San Luis, dividiendo los barrios de la Feria y San Julián en Sevilla, España.",
        "Ubicacion: Patio de Banderas, s/n, 41004 Sevilla, España",
        "Ubicacion: P.º de las Delicias, s/n, 41013 Sevilla, España",
        "Ubicacion: Pl. del Museo, 9, 41001 Sevilla, España",
        "Ubicacion: Av. de la Constitución, s/n, 41004 Sevilla, España",
        "Ubicacion: Av. de la Constitución, s/n, 41004 Sevilla, España",
        "Ubicacion: La plaza de toros de la Maestranza se encuentra en el barrio del Arenal de Sevilla, Andalucía, España.",
        "Ubicacion: La isla de la Cartuja es un terreno de la ciudad de Sevilla situado entre dos brazos del río Guadalquivir, uno río vivo y el otro una dársena.")

    val images = intArrayOf(
        R.drawable.plaza,
        R.drawable.setasdelaencarnacion,
        R.drawable.sandelosfranceses,
        R.drawable.reales,
        R.drawable.maria_luisa,
        R.drawable.bellas_artes,
        R.drawable.catedral,
        R.drawable.giralda,
        R.drawable.plaza_toros,
        R.drawable.isla_cartuja,


        )
    val rating = intArrayOf(10,5,7,8,9,3,4,5,8,6)





    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {

        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder:ViewHolder, i: Int) {

        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemImage.setImageResource(images[i])
        viewHolder.itemRatin.setProgress(rating[i])
        viewHolder.puntuacion.text = rating[i].toString()



        viewHolder.itemView.setOnClickListener { v: View ->

          if (i==0) {

              var intent = Intent(v.context, MainActivity3::class.java)
              v.context.startActivity(intent)
          }else if (i==1){
              var intent = Intent(v.context, MainActivity2::class.java)
              v.context.startActivity(intent)

          }else if (i==2){
              var intent = Intent(v.context, MainActivity4::class.java)
              v.context.startActivity(intent)


        }else if (i==3){
              var intent = Intent(v.context, MainActivity5::class.java)
              v.context.startActivity(intent)


        }else if (i==4){
              var intent = Intent(v.context, MainActivity6::class.java)
              v.context.startActivity(intent)


          }else if (i==5){
              var intent = Intent(v.context, MainActivity7::class.java)
              v.context.startActivity(intent)


          }else if (i==6){
              var intent = Intent(v.context, MainActivity8::class.java)
              v.context.startActivity(intent)


          }else if (i==7){
              var intent = Intent(v.context, MainActivity9::class.java)
              v.context.startActivity(intent)


          }else if (i==8){
              var intent = Intent(v.context, MainActivity10::class.java)
              v.context.startActivity(intent)


          }else if (i==9){
              var intent = Intent(v.context, MainActivity11::class.java)
              v.context.startActivity(intent)
          }

        }


    }

    override fun getItemCount(): Int {

        return titles.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

        var itemImage: ImageView
        var itemTitle: TextView
        var itemDetail: TextView
        var itemRatin: RatingBar
        var puntuacion: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detal)
            itemRatin = itemView.findViewById(R.id.ratingBar2)
            puntuacion = itemView.findViewById(R.id.datos_puntuacion)


        }


    }


}