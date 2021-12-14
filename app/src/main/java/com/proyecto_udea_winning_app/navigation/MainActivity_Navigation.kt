package com.proyecto_udea_winning_app.navigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.proyecto_udea_winning_app.LoginApp.LoginActivity
import com.proyecto_udea_winning_app.R
import com.proyecto_udea_winning_app.main.MainActivity
import com.proyecto_udea_winning_app.setting_activity.SettingActivity

class MainActivity_Navigation : AppCompatActivity() {

    lateinit var toogle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_navigation)

        drawerLayout = findViewById(R.id.drawerLayout)
        navigationView = findViewById(R.id.nav_view)

        toogle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toogle)
        toogle.syncState()


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        navigationView.setNavigationItemSelectedListener {

            when(it.itemId){
                R.id.item1 -> {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    true
                }

                R.id.item2 -> {

                    val intent = Intent(this, SettingActivity::class.java)
                    startActivity(intent)
                    true

                }

                R.id.item3 -> {

                    val intent = Intent(this, LoginActivity::class.java)
                    startActivity(intent)
                    Toast.makeText(this,"Muchas gracias por visitar nuestra App", Toast.LENGTH_LONG).show()

                    true

                }
                else -> false

            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toogle.onOptionsItemSelected(item)){
            true
        }
        return super.onOptionsItemSelected(item)

    }

}