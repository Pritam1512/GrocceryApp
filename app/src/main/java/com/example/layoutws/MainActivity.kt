package com.example.layoutws

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.GridView
import android.widget.LinearLayout
import com.example.layoutws.databinding.ActivityMainBinding
import com.example.layoutws.databinding.ButtonLayoutBinding
import com.example.layoutws.databinding.SingleProductItemBinding
import com.example.layoutws.databinding.SubitemLayoutBinding
import com.gtappdevelopers.kotlingfgproject.MyAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ButtonLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ButtonLayoutBinding.inflate(layoutInflater) // inflate the layout
        setContentView(binding.root)

//        val mAdapater = MyAdapter(this, listOf(1,2,3,4,5,6,7,8,9,10,11,12,334,45,54,45,45,4235,6,57,6756))
//        binding.gridVW.adapter = mAdapater

    }
}