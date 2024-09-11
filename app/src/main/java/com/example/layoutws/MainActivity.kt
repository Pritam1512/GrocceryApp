package com.example.layoutws

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.GridView
import android.widget.LinearLayout
import androidx.activity.viewModels
import com.example.layoutws.databinding.ActivityMainBinding
import com.example.layoutws.databinding.ButtonLayoutBinding
import com.example.layoutws.databinding.SingleProductItemBinding
import com.example.layoutws.databinding.SubitemLayoutBinding
import com.example.layoutws.viewmodel.MainViewModel
import com.gtappdevelopers.kotlingfgproject.MyAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel : MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // inflate the layout
        setContentView(binding.root)

        val mAdapater = MyAdapter(this, listOf(1,2,3,4,5,6,7,8,9,10,11,12,334,45,54,45,45,4235,6,57,6756))
        binding.gridVW.adapter = mAdapater

        mainViewModel.addOne()
        mainViewModel.addOne()
        mainViewModel.addOne()
        Log.i("MainActivity"," "+ mainViewModel.getCount())

    }
}