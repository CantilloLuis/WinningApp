package com.proyecto_udea_winning_app.conexion_retrofit_recyclerview

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("sitios_en_recyclerview")
    fun getData(): Call<List<MyData_SitiosTuristicosItem>>
}