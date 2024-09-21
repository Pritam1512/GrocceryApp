package com.example.layoutws.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.layoutws.R
import com.example.layoutws.data.SingleCartItems

class CartAdapter(private val mList: ArrayList<SingleCartItems>) : RecyclerView.Adapter<CartAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cart_single_item, parent, false)
        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val items = mList[position]
        holder.imageView.setImageResource(items.imageID)
        holder.descText.text = items.desc
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.cartItemImage)
        val descText :TextView = itemView.findViewById(R.id.cartItemText)
        val button :Button = itemView.findViewById(R.id.cartItemButton)
    }
}
