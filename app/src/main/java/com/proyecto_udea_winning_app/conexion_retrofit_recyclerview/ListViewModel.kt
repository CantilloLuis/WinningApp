package com.proyecto_udea_winning_app.conexion_retrofit_recyclerview

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ListViewModel : ViewModel() {

    private var SitiosTuristicosLoad_RecyclerView: MutableLiveData<List<MyData_SitiosTuristicosItem>> = MutableLiveData()
    val onSitiosTuristicosLoad_RecyclerView:  LiveData<List<MyData_SitiosTuristicosItem>> = SitiosTuristicosLoad_RecyclerView



     fun getMyData() {

        val retrofitBuilder =  Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://my-json-server.typicode.com/CantilloLuis/Datos_Sitios_turisticos_RecyclerView/")
            .build()
            .create(ApiInterface::class.java)



        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<MyData_SitiosTuristicosItem>?> {

            override fun onResponse(call: Call<List<MyData_SitiosTuristicosItem>?>, response: Response<List<MyData_SitiosTuristicosItem>?>)
            {
                val responseBody = response.body()!!
                SitiosTuristicosLoad_RecyclerView.value = responseBody

            }

            override fun onFailure(call: Call<List<MyData_SitiosTuristicosItem>?>, t: Throwable)
            {
                Log.d("MainActivity", "onFailure" + t.message)

            }
        })
    }
}