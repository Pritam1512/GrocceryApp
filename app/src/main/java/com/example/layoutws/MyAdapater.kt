package com.gtappdevelopers.kotlingfgproject

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.layoutws.R

class MyAdapter(private val context: Context, private val data: List<Int>) : BaseAdapter() {

    private lateinit var layoutInflater: LayoutInflater
    private lateinit var imageIV: ImageView
    override fun getCount(): Int {
        return data.size
    }

    override fun getItem(position: Int): Any {
        return data[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        Log.i("Adapter","init")
        var cView = convertView
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        Log.i("Adapter", "layoutInflator :: $layoutInflater")
        if (cView == null) {
            cView = layoutInflater.inflate(R.layout.button_layout,null)
        }
        Log.i("Adapter", "cView :: $cView")
        imageIV = cView!!.findViewById(R.id.imageView1)
        imageIV.setImageResource(R.drawable.hotel_svgrepo_com)

        return cView
    }
}
