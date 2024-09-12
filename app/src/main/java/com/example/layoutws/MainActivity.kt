package com.example.layoutws

import android.app.Dialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.GridView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.layoutws.databinding.ActivityMainBinding
import com.example.layoutws.databinding.ButtonLayoutBinding
import com.example.layoutws.databinding.SingleProductItemBinding
import com.example.layoutws.databinding.SubitemLayoutBinding
import com.example.layoutws.viewmodel.MainViewModel
import com.gtappdevelopers.kotlingfgproject.MyAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel : MainViewModel by viewModels()
    lateinit var title:Array<String>
    private lateinit var newList: ArrayList<cartItem>
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

        title = arrayOf(
            "Title 1",
            "Title 2",
            "Title 3",
            "Title 4",
            "Title 5",
            "Title 6",
            "Title 7"
        )
        binding.cartRV.layoutManager = LinearLayoutManager(this)
        binding.cartRV.setHasFixedSize(true)
        newList = arrayListOf<cartItem>()
        getAllData()
        for(i in title){
            val title = cartItem(i)
            newList.add(title)

        }

        binding.addItemsInCartButton.setOnClickListener{
            val title = cartItem("someRandomValue")
            newList.add(title)
            binding.cartRV.adapter = CartAdapter(newList)
        }
    }
    private fun getAllData() {
        binding.cartRV.adapter = CartAdapter(newList)
    }
}