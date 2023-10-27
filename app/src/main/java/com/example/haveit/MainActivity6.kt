package com.example.haveit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)
        supportActionBar?.hide()
        val price3 = findViewById<TextView>(R.id.price3)
        val image3 = findViewById<ImageView>(R.id.image3)
        val flat3 = findViewById<TextView>(R.id.flat3)
        val dish3 = findViewById<TextView>(R.id.dish3)
        val owner3 = findViewById<TextView>(R.id.owner3)
        val dining3 = findViewById<TextView>(R.id.dining3)
        val description3 = findViewById<TextView>(R.id.description3)
        val image = intent.getIntExtra("image2",0)
        dish3.text = intent.getStringExtra("dish")
        owner3.text = intent.getStringExtra("owner")
        dining3.text = intent.getStringExtra("dining")
        flat3.text = intent.getStringExtra("flat")
        price3.text=intent.getStringExtra("price")
        image3.setImageResource(image)
        description3.text = intent.getStringExtra("description")
    }
}

