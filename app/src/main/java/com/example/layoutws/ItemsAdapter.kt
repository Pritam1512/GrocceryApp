package com.example.layoutws

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemsAdapter(private val mList: ArrayList<cartItem>) : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.button_layout, parent, false)
        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val imageId = mList[position]
        holder.imageView.setImageResource(imageId.imageID)
        holder.itemDesc.text = imageId.desc
        holder.price.text = imageId.price.toString()
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
        val itemDesc: TextView = itemView.findViewById(R.id.itemDesc)
        val price: TextView = itemView.findViewById(R.id.itemPrice)
        val button:Button = itemView.findViewById(R.id.button)

    }
}