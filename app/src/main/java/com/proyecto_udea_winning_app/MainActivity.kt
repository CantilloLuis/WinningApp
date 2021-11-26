package com.proyecto_udea_winning_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RatingBar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONException
import org.json.JSONObject
import java.io.IOException
import java.nio.charset.Charset

class MainActivity : AppCompatActivity() {

    var titles: ArrayList<String> = ArrayList()
    var details: ArrayList<String> = ArrayList()
    var images: ArrayList<String> = ArrayList()
    var rating: ArrayList<Int> = ArrayList()
    var rating2: ArrayList<Double> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.supportActionBar?.hide()
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val adapter = CustomAdapter(titles,details,images,rating,rating2)
        recyclerView.layoutManager = LinearLayoutManager(this )
        recyclerView.adapter = adapter


        try {
            val obj = JSONObject(loadJSONFromAsset())
            val userArray = obj.getJSONArray("sitios")
            for (i in 0 until userArray.length()) {
                val userDetail = userArray.getJSONObject(i)
                     titles.add(userDetail.getString("titles"))
                     details.add(userDetail.getString("details"))
                     images.add(userDetail.getString("images"))
                     rating.add(userDetail.getInt("rating"))
                     rating2.add(userDetail.getDouble("rating2"))

            }
        }
        catch (e: JSONException) {
            e.printStackTrace()
        }
        val customAdapter = CustomAdapter(titles,details,images,rating,rating2)
        recyclerView.adapter = customAdapter
    }
    private fun loadJSONFromAsset(): String {
        val json: String?
        try {
            val inputStream = assets.open("SitiosTuristicos.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            val charset: Charset = Charsets.UTF_8
            inputStream.read(buffer)
            inputStream.close()
            json = String(buffer, charset)
        }
        catch (ex: IOException) {
            ex.printStackTrace()
            return ""
        }
        return json
    }

}


