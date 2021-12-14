package com.proyecto_udea_winning_app.LoginApp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.proyecto_udea_winning_app.R

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var txtEmail: EditText
    private lateinit var auth: FirebaseAuth
    private lateinit var progressBar: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        txtEmail  = findViewById(R.id.txtEmail2)
        auth = FirebaseAuth.getInstance()
        progressBar = findViewById(R.id.progressBar3)

    }

    fun send(view: View){

        val email = txtEmail.text.toString()

        if(!TextUtils.isEmpty(email)){

            auth.sendPasswordResetEmail(email)
                .addOnCompleteListener(this){ task ->

                    if(task.isSuccessful){
                        progressBar.visibility = View.VISIBLE
                        Toast.makeText(this,"Mensaje enviado a tu correo para restablecer tu contraseña", Toast.LENGTH_LONG).show()
                        startActivity(Intent(this, LoginActivity::class.java))

                    }
                    else{

                        Toast.makeText(this,"Error para restablecer contraseña", Toast.LENGTH_LONG).show()

                    }
                }
        }else{

            Toast.makeText(this,"Complete el campo requerido", Toast.LENGTH_LONG).show()

        }


    }
}