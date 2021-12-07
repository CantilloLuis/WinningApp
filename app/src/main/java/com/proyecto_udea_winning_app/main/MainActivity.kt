package com.proyecto_udea_winning_app.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.proyecto_udea_winning_app.R
import com.proyecto_udea_winning_app.adapter.CustomAdapter
import com.proyecto_udea_winning_app.conexion_retrofit_recyclerview.ListViewModel

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var Myadapter: CustomAdapter
    lateinit var listViewModel: ListViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)


        listViewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        listViewModel.getMyData()

        listViewModel.onSitiosTuristicosLoad_RecyclerView.observe(this, Observer {

            Myadapter = CustomAdapter(baseContext, it)
            Myadapter.notifyDataSetChanged()
            recyclerView.adapter = Myadapter

        })

    }

}


