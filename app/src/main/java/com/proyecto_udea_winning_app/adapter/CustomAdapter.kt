package com.proyecto_udea_winning_app.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.proyecto_udea_winning_app.*
import com.proyecto_udea_winning_app.clases_layout.*
import com.proyecto_udea_winning_app.conexion_retrofit_recyclerview.MyData_SitiosTuristicosItem

class CustomAdapter(
    val context: Context,
    val userList: List<MyData_SitiosTuristicosItem>


): RecyclerView.Adapter<CustomAdapter.ViewHolder>() {



    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {

        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_layout, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {


        viewHolder.itemTitle.text = userList[i].titles
        viewHolder.itemDetail.text = userList[i].details
        Glide.with(context).load(userList[i].images).into(viewHolder.itemImage)
        viewHolder.itemRating.setProgress(userList[i].rating.toInt())
        viewHolder.puntuacion.text = userList[i].rating2




        viewHolder.itemView.setOnClickListener { v: View ->

          if(i==0) {

              val intent = Intent(v.context, plaza_espana::class.java)
              v.context.startActivity(intent)
          }else if (i==1){
              val intent = Intent(v.context, setas_encarnacion::class.java)
              v.context.startActivity(intent)

          }else if (i==2){
              val intent = Intent(v.context, iglesia_san_luis::class.java)
              v.context.startActivity(intent)


        }else if (i==3){
              val intent = Intent(v.context, reales_alcazares::class.java)
              v.context.startActivity(intent)


        }else if (i==4){
              val intent = Intent(v.context, parque_maria_luisa::class.java)
              v.context.startActivity(intent)


          }else if (i==5){
              val intent = Intent(v.context, museo_bellas_artes::class.java)
              v.context.startActivity(intent)


          }else if (i==6){
              val intent = Intent(v.context, catedral::class.java)
              v.context.startActivity(intent)


          }else if (i==7){
              val intent = Intent(v.context, torre_giralda::class.java)
              v.context.startActivity(intent)


          }else if (i==8){
              val intent = Intent(v.context, plaza_toros::class.java)
              v.context.startActivity(intent)


          }else if (i==9){
              val intent = Intent(v.context, isla_cartuja::class.java)
              v.context.startActivity(intent)
          }

        }


    }

    override fun getItemCount(): Int {

        return userList.size
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