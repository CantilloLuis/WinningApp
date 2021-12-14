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
import com.proyecto_udea_winning_app.navigation.MainActivity_Navigation

class LoginActivity : AppCompatActivity() {

    private lateinit var txtUser: EditText
    private lateinit var txtPassword: EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        txtUser = findViewById(R.id.txtUser)
        txtPassword = findViewById(R.id.txtPassword2)
        progressBar = findViewById(R.id.progressBar2)
        auth = FirebaseAuth.getInstance()

    }
    fun forgotPassword(view: View){

        startActivity(Intent(this, ForgotPasswordActivity::class.java))

    }

    fun registerUser(view: View){

        startActivity(Intent(this, RegisterActivity::class.java))

    }

    fun login(view: View){

        loginUser()

    }

    fun loginUser(){

        val user: String = txtUser.text.toString()
        val password: String = txtPassword.text.toString()

        if(!TextUtils.isEmpty(user) && !TextUtils.isEmpty(password)){

            progressBar.visibility = View.VISIBLE
            auth.signInWithEmailAndPassword(user,password)
                .addOnCompleteListener(this){ task ->

                    if(task.isSuccessful){
                        startActivity(Intent(this,MainActivity_Navigation::class.java))
                    }
                    else{

                        Toast.makeText(this,"Error en la autenticacion, contraseña o correo incorrecto", Toast.LENGTH_LONG).show()
                        progressBar.visibility = View.INVISIBLE

                    }
                }

        }else{

            Toast.makeText(this,"Complete todos los campos requeridos", Toast.LENGTH_LONG).show()

        }

    }
}