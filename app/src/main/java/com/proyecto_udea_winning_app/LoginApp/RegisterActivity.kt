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
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.proyecto_udea_winning_app.R

class RegisterActivity : AppCompatActivity() {

    private lateinit var txtName: EditText
    private lateinit var txtLastName:EditText
    private lateinit var txtEmail:EditText
    private lateinit var txtPassword:EditText
    private lateinit var progressBar: ProgressBar
    private lateinit var dbReference: DatabaseReference
    private lateinit var database: FirebaseDatabase
    private lateinit var auth: FirebaseAuth
    private lateinit var db: FirebaseFirestore



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        txtName = findViewById(R.id.txtName)
        txtLastName = findViewById(R.id.txtLastName)
        txtEmail  = findViewById(R.id.txtEmail)
        txtPassword = findViewById(R.id.txtPassword)
        progressBar = findViewById(R.id.progressBar)
        database = FirebaseDatabase.getInstance()
        auth = FirebaseAuth.getInstance()
        db = FirebaseFirestore.getInstance()


        dbReference = database?.reference!!.child("profile")

    }

    fun register(view: View){

        createNewAccount()


    }

    private fun createNewAccount(){
        val name: String = txtName.text.toString()
        val lastName: String = txtLastName.text.toString()
        val email: String = txtEmail.text.toString()
        val password: String = txtPassword.text.toString()

        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(lastName) && !TextUtils.isEmpty(email) &&  !TextUtils.isEmpty(password)){
             progressBar.visibility = View.VISIBLE

            auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this){ task ->
                    if(task.isComplete){
                        val user:FirebaseUser? = auth.currentUser
                        val user2 = auth.currentUser
                        verifyEmail(user)
                        val uid = user2!!.uid
                        val map = hashMapOf(
                            "Name" to name,
                            "LastName" to lastName,
                            "Email" to email
                        )
                        val datos = db.collection("user").document(uid).set(map)
                        action()

                    }
                }
        }else{

            Toast.makeText(this,"Complete todos los campos requeridos", Toast.LENGTH_LONG).show()

        }
    }
    private fun action(){
        startActivity(Intent(this, LoginActivity::class.java))
    }

    private fun verifyEmail(user:FirebaseUser?){
        user?.sendEmailVerification()
            ?.addOnCompleteListener(this){task ->

                if(task.isComplete){
                    Toast.makeText(this,"Creacion de cuenta exitosa", Toast.LENGTH_LONG).show()
                }
                else{

                    Toast.makeText(this,"Error al crear la cuenta", Toast.LENGTH_LONG).show()

                }
            }
    }
}


