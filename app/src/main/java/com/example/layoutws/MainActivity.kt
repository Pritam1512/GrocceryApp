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

    private lateinit var binding: CartSingleItemBinding
    private val mainViewModel : MainViewModel by viewModels()
    private lateinit var newList: ArrayList<cartItem>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CartSingleItemBinding.inflate(layoutInflater) // inflate the layout
        setContentView(binding.root)

//        newList = arrayListOf() // create a list of cart items
//        newList.add(cartItem("First"))
//        newList.add(cartItem("Second"))
//        newList.add(cartItem("Third"))
//        newList.add(cartItem("Fourth"))
//        newList.add(cartItem("Fourth"))
//        newList.add(cartItem("Fourth"))
//        newList.add(cartItem("Fourth"))
//        newList.add(cartItem("Fourth"))
//        newList.add(cartItem("Fourth"))
//        newList.add(cartItem("Fourth"))
//        newList.add(cartItem("Fourth"))
//        newList.add(cartItem("Fourth"))
//        newList.add(cartItem("Fourth"))
//        newList.add(cartItem("Fourth"))
//        newList.add(cartItem("Fourth"))
//        newList.add(cartItem("Fourth"))
//        newList.add(cartItem("Fourth"))
//        newList.add(cartItem("Fourth"))
//        newList.add(cartItem("Fourth"))
//        newList.add(cartItem("Fourth"))
//        newList.add(cartItem("Fourth"))
//        newList.add(cartItem("Fourth"))
//        newList.add(cartItem("Fourth"))
//        val mAdapater = CartAdapter(newList)
//        val gridLayoutManager = GridLayoutManager(this, 3)
//        binding.cartRV.layoutManager = gridLayoutManager
//
//        binding.cartRV.setHasFixedSize(true)
//        binding.cartRV.adapter = mAdapater
//
//        // to disable scrolling of RV within the scrollview
//        binding.cartRV.isNestedScrollingEnabled = false
    }

}