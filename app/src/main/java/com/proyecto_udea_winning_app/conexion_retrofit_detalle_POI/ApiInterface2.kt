package com.proyecto_udea_winning_app.conexion_retrofit_detalle_POI

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface2 {

    @GET("sitios_en_interface_detalle")
    fun getData(): Call<List<MyDataSitiosTuristicos2Item>>
}