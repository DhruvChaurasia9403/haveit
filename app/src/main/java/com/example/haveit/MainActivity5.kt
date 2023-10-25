package com.example.haveit

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity5 : AppCompatActivity() {
    lateinit var myRecyclerView: RecyclerView
    lateinit var myRecyclerView2: RecyclerView
    val nameList = ArrayList<Name>()
    val nameList2 = ArrayList<Name2>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        supportActionBar?.hide()

        val image = arrayOf(
            R.drawable.ig3,
            R.drawable.ig2,
            R.drawable.ig9,
            R.drawable.ig8,
            R.drawable.ig5,
            R.drawable.ig3,
            R.drawable.ig7,
            R.drawable.ig8
        )
        val owner = arrayOf(
            "Sharma ji",
            "Rajesh Yadav",
            "Pankaj Kumar",
            "Rajesh Yadav",
            "Anjali",
            "Chintu",
            "Chunkey Pandey",
            "Prakhar Srivastava"
        )

        val name = arrayOf(
            "Flat Number-101",
            "Flat Number-302",
            "Flat number-303",
            "Flat Number-302",
            "Flat Number-905",
            "Flat Number-206",
            "Flat Number-607",
            "Flat Number-408"
        )
        val price = arrayOf(
            "120/-",
            "150/-",
            "100/-",
            "200/-",
            "150/-",
            "120/-",
            "100/-",
            "200/-"
        )
        val dining = arrayOf(
            "Dining for 2",
            "Dining for 1",
            "Dining for 3",
            "Dining for 1",
            "Dining for 2",
            "Dining for 2",
            "Dining for 3",
            "Dining for 1"
        )
        val dish = arrayOf(
            "Mixed Veg.",
            "Paneer Tikka",
            "Veg. Biryani",
            "Dal Makhani",
            "Paneer Tikka",
            "Mixed Veg.",
            "Veg. Biryani",
            "Chaap"
        )

        myRecyclerView = findViewById<RecyclerView>(R.id.RV1)
        myRecyclerView2 = findViewById<RecyclerView>(R.id.RV2)
        myRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        myRecyclerView2.layoutManager = LinearLayoutManager(this)
        for (i in image.indices) {
            val item = Name(name[i], image[i] )
            nameList.add(item)
        }
        for(j in image.indices){
            val item2 = Name2(name[j],image[j],dining[j],dish[j],price[j])
            nameList2.add(item2)
        }
        val adap2 = MyAdapter2(nameList2,this)
        myRecyclerView2.adapter = MyAdapter2(nameList2,this)

        val adap = MyAdapter(nameList, this)
        val adapter = adap
        myRecyclerView.adapter = adapter
        adap.setOnItemClickListner(object : MyAdapter.onClickListner {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity5, MainActivity6::class.java)
                intent.putExtra("flat", nameList[position].flat)
                intent.putExtra("image", image[position])
                startActivity(intent)
            }
        })

        adap2.setOnItemClickListener2(object : MyAdapter2.onClickListner2 {
            override fun onItemClick2(position: Int) {
                val intent = Intent(this@MainActivity5, MainActivity6::class.java)
                intent.putExtra("flat", nameList2[position].flat2)
                intent.putExtra("image", image[position])
                intent.putExtra("dining", dining[position])
                intent.putExtra("dish", dish[position])
                intent.putExtra("owner", owner[position])
                intent.putExtra("price", price[position])
                startActivity(intent)
            }
        })


    }
}
