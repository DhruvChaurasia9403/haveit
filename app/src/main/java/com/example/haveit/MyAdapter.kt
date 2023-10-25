package com.example.haveit
import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
class MyAdapter(val list1: ArrayList<Name>, val context: Activity) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    lateinit var myListner : onClickListner
    interface onClickListner{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListner(listner:onClickListner){
        myListner = listner
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.upper, parent, false)
        return MyViewHolder(itemView,myListner)
    }
    override fun getItemCount(): Int {
        return list1.size
    }
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = list1[position]
        holder.name.text = currentItem.flat
        holder.image.setImageResource(currentItem.image1)
    }
    inner class MyViewHolder(itemView: View,listner: onClickListner) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.image1)
        val name: TextView = itemView.findViewById(R.id.flat1)
        init{
            itemView.setOnClickListener{
                listner?.onItemClick(adapterPosition)
            }
        }
    }
}
