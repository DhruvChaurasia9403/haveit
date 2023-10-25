package com.example.haveit

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class MyAdapter2(val List2 :ArrayList<Name2>,val context:Activity):
    RecyclerView.Adapter<MyAdapter2.MyViewHolder>() {
    lateinit var myListner2 : onClickListner2
    interface onClickListner2{
        fun onItemClick2(position: Int)
    }
    fun setOnItemClickListener2(listener:onClickListner2){
        myListner2 = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter2.MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.lower,parent,false)
        return MyViewHolder(itemView,myListner2)
    }

    override fun onBindViewHolder(holder: MyAdapter2.MyViewHolder, position: Int) {
        val currentItem = List2[position]
        holder.img.setImageResource(currentItem.image2)
        holder.name2.text = currentItem.flat2
        holder.dining2.text = currentItem.dining
        holder.dish2.text = currentItem.dish
        holder.price2.text = currentItem.price
    }

    override fun getItemCount(): Int {
        return List2.size
    }

    class MyViewHolder (itemView : View,myListner2:onClickListner2):RecyclerView.ViewHolder(itemView){
        val img = itemView.findViewById<ShapeableImageView>(R.id.image2)
        val name2 = itemView.findViewById<TextView>(R.id.flat2)
        val dining2 = itemView.findViewById<TextView>(R.id.dining)
        val dish2 = itemView.findViewById<TextView>(R.id.dish)
        val price2 = itemView.findViewById<TextView>(R.id.price)
        init{
            itemView.setOnClickListener{
                myListner2?.onItemClick2(adapterPosition)
            }
        }
    }
}