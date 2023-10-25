package com.example.haveit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity3 : AppCompatActivity() {
    lateinit var database : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        database = FirebaseDatabase.getInstance().getReference("user")
        supportActionBar?.hide()

        val id = findViewById<EditText>(R.id.idIn)
        val password = findViewById<EditText>(R.id.passwordIn)
        val login = findViewById<Button>(R.id.login)
        login.setOnClickListener{
            val uniqueId = id.text.toString()
            val pass = password.text.toString()
            if(uniqueId.isNotEmpty() && pass.isNotEmpty()){
                database.child(uniqueId).get().addOnSuccessListener {
                    if(it.exists()){//check if uniqueId as in child exists in database
                        val name1 = it.child("name").value
                        val id1 = it.child("id").value
                        val pass1 = it.child("pass").value
                        if(id1==uniqueId) {//if uniqueId exists in database check if the id matches the input id
                            if (pass1 == pass) {//if id equals input id check if password matches
                                Toast.makeText(applicationContext, "welcome $name1", Toast.LENGTH_SHORT).show()
                                val intent = Intent(this, MainActivity4::class.java)
                                intent.putExtra("name", name1.toString())
                                startActivity(intent)
                            } else {
                                Toast.makeText(applicationContext, "incorrect password", Toast.LENGTH_SHORT).show()
                                password.text.clear()
                            }
                        }else{
                            Toast.makeText(applicationContext, "incorrect id", Toast.LENGTH_SHORT).show()
                            id.text.clear()
                            password.text.clear()
                        }
                    } else{
                        Toast.makeText(this, "User does not exist", Toast.LENGTH_SHORT).show()
                        val intent = Intent(this, MainActivity2::class.java)
                    }
                }.addOnFailureListener{
                    Toast.makeText(this, "failed", Toast.LENGTH_SHORT).show()
                }
            } else{
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
        val signUp = findViewById<TextView>(R.id.inToUp)
        signUp.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }

    }
}