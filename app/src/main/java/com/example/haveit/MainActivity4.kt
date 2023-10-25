package com.example.haveit

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        supportActionBar?.hide()
        val belly = findViewById<Button>(R.id.belly)
        val name = findViewById<TextView>(R.id.name)
        name.text = intent.getStringExtra("name")
        belly.setOnClickListener{
            val intent = Intent(this,MainActivity5::class.java)
            startActivity(intent)
        }
    }
}