package com.proyecto_udea_winning_app

import android.content.Context
import android.content.Intent
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
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
import com.squareup.picasso.Picasso

class CustomAdapter(

    private var titles: ArrayList<String>,
    private var details: ArrayList<String>,
    private var images1: ArrayList<String>,
    private var rating_int: ArrayList<Int>,
    private var rating_double: ArrayList<Double>


): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

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


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {

        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder:ViewHolder, i: Int) {


        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemDetail.text = details[i]
        viewHolder.itemImage.setImageResource(images[i])
        viewHolder.itemRating.setProgress(rating_int[i])
        viewHolder.puntuacion.text = rating_double[i].toString()




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
        var itemRating: RatingBar
        var puntuacion: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detal)
            itemRating = itemView.findViewById(R.id.ratingBar2)
            puntuacion = itemView.findViewById(R.id.datos_puntuacion)


        }


    }


}