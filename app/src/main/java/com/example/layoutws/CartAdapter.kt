package com.example.layoutws

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CartAdapter(private val mList: ArrayList<cartItem>) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.button_layout, parent, false)
        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val itemsName = mList[position]
        holder.imageView.setImageResource(R.drawable.hotel_svgrepo_com)

        holder.imageView.setOnClickListener {
            Log.i("Adapter", "onBindViewHolder: Image Item clicked $position")
        }
        holder.button.setOnClickListener{
            Log.i("Adapter", "onBindViewHolder: Button Item clicked $position")
        }

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.imageView1)
        val button:Button = itemView.findViewById(R.id.button)

//        imageIV = item.findViewById(R.id.imageView1)
//        buttonBV = cView.findViewById(R.id.button)
//        imageIV.setImageResource(R.drawable.hotel_svgrepo_com)
//
//        imageIV.setOnClickListener {
//            // start activity to show product info
//        }
//        buttonBV.setOnClickListener{
//            // start activity to add the item in cart and show the cart
//            // car visibility = View.VISIBLE
//        }
    }
}