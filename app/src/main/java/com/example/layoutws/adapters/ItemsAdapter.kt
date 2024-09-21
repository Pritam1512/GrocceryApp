package com.example.layoutws.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.layoutws.R
import com.example.layoutws.data.cartItem

class ItemsAdapter(private val mList: ArrayList<cartItem>, private val listener: OnItemClickListener) : RecyclerView.Adapter<ItemsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_item_information_layout, parent, false)
        return ViewHolder(view)
    }

    interface OnItemClickListener {
        fun onItemImageClick(position: Int)
        fun onItemButtonClick(position: Int)
    }
    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val imageId = mList[position]
        holder.imageView.setImageResource(imageId.imageID)
        holder.itemDesc.text = imageId.desc
        holder.price.text = imageId.price.toString()

        holder.imageView.setOnClickListener {
            // start new activity for item info
            listener.onItemImageClick(position)
            Log.i("Adapter", "onBindViewHolder: Image Item clicked $position")
        }

        holder.button.setOnClickListener{
            // add item to cart and change button state
            listener.onItemButtonClick(position)
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