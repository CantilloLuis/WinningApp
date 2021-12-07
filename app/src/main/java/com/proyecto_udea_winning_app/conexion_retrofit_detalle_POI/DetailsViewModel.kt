package com.proyecto_udea_winning_app.conexion_retrofit_detalle_POI

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DetailsViewModel: ViewModel() {

    private var SitiosTuristicosLoad_InterfaceDetalle: MutableLiveData<List<MyDataSitiosTuristicos2Item>> = MutableLiveData()
    val onSitiosTuristicosLoad_InterfaceDetalle: LiveData<List<MyDataSitiosTuristicos2Item>> = SitiosTuristicosLoad_InterfaceDetalle


     fun getMyData() {

        val retrofitBuilder =  Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://my-json-server.typicode.com/CantilloLuis/Datos_Sitios_turisticos_Detalle_interface/")
            .build()
            .create(ApiInterface2::class.java)

        val retrofitData = retrofitBuilder.getData()

        retrofitData.enqueue(object : Callback<List<MyDataSitiosTuristicos2Item>?> {

            override fun onResponse(call: Call<List<MyDataSitiosTuristicos2Item>?>, response: Response<List<MyDataSitiosTuristicos2Item>?>)
            {
                val responseBody = response.body()!!
                SitiosTuristicosLoad_InterfaceDetalle.value  = responseBody

            }

            override fun onFailure(call: Call<List<MyDataSitiosTuristicos2Item>?>, t: Throwable)
            {
                Log.d("MainActivity", "onFailure" + t.message)

            }
        })

    }


}