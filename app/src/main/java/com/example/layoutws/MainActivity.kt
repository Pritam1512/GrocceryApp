package com.example.layoutws

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.GridView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.layoutws.databinding.ActivityMainBinding
import com.example.layoutws.databinding.TapviewNewUiBinding
import com.example.layoutws.viewmodel.ItemCountViewModel
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity(),ItemsAdapter.OnItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel : ItemCountViewModel by viewModels()
    private lateinit var newList: ArrayList<cartItem>
    private lateinit var cartList: ArrayList<SingleCartItems>
    private lateinit var imageId: IntArray
    private lateinit var description: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // inflate the layout
        setContentView(binding.root)

        prepareDummyData()
        setAdapters()
        disbaleRecyclerViewScrolling()
    }


    private fun setAdapters() {
        val cAdapter = CartAdapter(cartList)
        binding.cartRV.layoutManager = LinearLayoutManager(this)
        binding.cartRV.setHasFixedSize(true)
        binding.cartRV.adapter = cAdapter


        // set items adapter
        val mAdapater = ItemsAdapter(newList,this)
        val gridLayoutManager = GridLayoutManager(this, 3)
        binding.itemsRV.layoutManager = gridLayoutManager
        binding.itemsRV.setHasFixedSize(true)
        binding.itemsRV.adapter = mAdapater
    }

    private fun prepareDummyData() {

        imageId = intArrayOf(
            R.drawable.chicken_food_thanksgiving_svgrepo_com,
            R.drawable.apple_svgrepo_com,
            R.drawable.banana_svgrepo_com__1_,
            R.drawable.burger_1_svgrepo_com,
            R.drawable.chips_snack_svgrepo_com,
            R.drawable.coke_svgrepo_com,
            R.drawable.cookies_svgrepo_com,
            R.drawable.fish_svgrepo_com,
            R.drawable.fries_svgrepo_com,
            R.drawable.tomato_svgrepo_com,
            R.drawable.pizza_svgrepo_com,
            R.drawable.omelette_svgrepo_com,
            R.drawable.rice_svgrepo_com,
            R.drawable.hotel_svgrepo_com
        )
        description = arrayOf(
            "Chicken",
            "Apple",
            "Banana",
            "Burger",
            "Chips",
            "Coke",
            "Cookies",
            "Fish",
            "Fries",
            "Tomato",
            "Pizza",
            "Omelette",
            "rice",
            "Hotel"
        )
        val price = arrayOf(
            12,34.5,54.7,23,45.33,5,56,4,5.2,46,67,34.6,5,65
        )

        newList = arrayListOf() // create a list of items
        for(i in imageId.indices) {
            newList.add(cartItem(imageId[i],description[i],price[i].toFloat()))
        }

        cartList = arrayListOf() // create list of cart items
    }

    private fun disbaleRecyclerViewScrolling() {
        // to disable scrolling of RV within the scrollview
        binding.itemsRV.isNestedScrollingEnabled = false
    }

    override fun onItemImageClick(position: Int) {
        Toast.makeText(this,"Item image clicked $position",Toast.LENGTH_LONG).show()
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onItemButtonClick(position: Int) {
        Toast.makeText(this,"Item button clicked $position",Toast.LENGTH_LONG).show()
        cartList.add(SingleCartItems(imageId[position],description[position],1.1f))
        binding.cartRV.adapter?.notifyDataSetChanged()
    }
    companion object{
        private const val TAG = "MainActivity"
    }

}