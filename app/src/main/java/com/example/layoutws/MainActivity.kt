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
import androidx.appcompat.widget.ButtonBarLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.layoutws.databinding.ActivityMainBinding
import com.example.layoutws.databinding.ButtonLayoutBinding
import com.example.layoutws.databinding.CartSingleItemBinding
import com.example.layoutws.databinding.SingleProductItemBinding
import com.example.layoutws.databinding.SubitemLayoutBinding
import com.example.layoutws.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel : MainViewModel by viewModels()
    private lateinit var newList: ArrayList<cartItem>
    private lateinit var cartList: ArrayList<SingleCartItems>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // inflate the layout
        setContentView(binding.root)

        prepareDummyData()

        // set cart adapter
        val cAdapter = CartAdapter(cartList)
        binding.cartRV.layoutManager = LinearLayoutManager(this)
        binding.cartRV.setHasFixedSize(true)
        binding.cartRV.adapter = cAdapter


        // set items adapter
        val mAdapater = ItemsAdapter(newList)
        val gridLayoutManager = GridLayoutManager(this, 3)
        binding.itemsRV.layoutManager = gridLayoutManager

        binding.itemsRV.setHasFixedSize(true)
        binding.itemsRV.adapter = mAdapater

        disbaleRecyclerViewScrolling()

    }
    private fun prepareDummyData() {
        newList = arrayListOf() // create a list of cart items
        newList.add(cartItem("First"))
        newList.add(cartItem("Second"))
        newList.add(cartItem("Third"))
        newList.add(cartItem("Fourth"))
        newList.add(cartItem("Fifth"))
        newList.add(cartItem("Sixth"))
        newList.add(cartItem("Seventh"))
        newList.add(cartItem("Eighth"))
        newList.add(cartItem("Ninth"))
        newList.add(cartItem("Tenth"))
        newList.add(cartItem("11th"))
        newList.add(cartItem("12th"))
        newList.add(cartItem("13th"))
        newList.add(cartItem("14th"))
        newList.add(cartItem("15th"))
        newList.add(cartItem("16th"))

        cartList = arrayListOf()
        cartList.add(SingleCartItems(0))
        cartList.add(SingleCartItems(1))
        cartList.add(SingleCartItems(2))

    }

    private fun disbaleRecyclerViewScrolling() {
        // to disable scrolling of RV within the scrollview
        binding.itemsRV.isNestedScrollingEnabled = false
    }


}