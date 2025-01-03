package com.example.layoutws

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.layoutws.adapters.CartAdapter
import com.example.layoutws.adapters.ItemsAdapter
import com.example.layoutws.data.SingleCartItems
import com.example.layoutws.data.cartItem
import com.example.layoutws.database.ItemsData
import com.example.layoutws.databinding.ActivityMainBinding
import com.example.layoutws.viewmodel.CartItemsViewModel
import com.example.layoutws.viewmodel.ItemCountViewModel
import kotlin.math.log

class MainActivity : AppCompatActivity(),ItemsAdapter.OnItemClickListener,CartAdapter.OnCartItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private val cartItemsViewModel: CartItemsViewModel by viewModels() // view model instance
    private lateinit var newList: ArrayList<cartItem>
    private lateinit var cartList: ArrayList<SingleCartItems>
    private lateinit var itemsData: ItemsData

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "onCreate called")
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // inflate the layout
        setContentView(binding.root)

        prepareDummyData()
        setAdapters()

        setUpCartItemsFromIntent()
        setUpCartObservers()
        disbaleRecyclerViewScrolling()
    }
    private fun setUpCartItemsFromIntent(){
        Log.i(TAG, "setUpCartItemsFromIntent called")
        // update the viewmodel with the items from the intent
        val itemsHashArrayFromIntent = intent.getStringArrayListExtra("items_hash_array")
        if (itemsHashArrayFromIntent != null) {
            Log.i(TAG,"array size :: ${itemsHashArrayFromIntent?.size}")
            for (item in itemsHashArrayFromIntent) {
                Log.i(TAG,"items from previous activity $item")
                cartItemsViewModel.addItemsInCart(item)
            }
        } else{
            Log.i("MainActivity", "No items from previous activity")
        }
    }
    private fun setAdapters() {
        val cAdapter = CartAdapter(cartList, this)
        binding.cartRV.layoutManager = LinearLayoutManager(this)
        binding.cartRV.setHasFixedSize(true)
        binding.cartRV.adapter = cAdapter


        // set items adapter
        val mAdapater = ItemsAdapter(newList, this)
        val gridLayoutManager = GridLayoutManager(this, 3)
        binding.itemsRV.layoutManager = gridLayoutManager
        binding.itemsRV.setHasFixedSize(true)
        binding.itemsRV.adapter = mAdapater
    }

    private fun setUpCartObservers() {
        cartItemsViewModel.cartItemsList.observe(this, Observer {

            Log.i(TAG, ":: Cart data changed")
            var tempListArray = ArrayList<SingleCartItems>()
            for(itemhash in it){
                Log.i(TAG,"Item in cart = ${ItemsData.UUIDToProductMap[itemhash]}")
            }
            for (itemsHash in it) {
                tempListArray.add(
                    SingleCartItems(
                        itemsHash,
                        ItemsData.UUIDToProductMap[itemsHash]!!.imageId,
                        ItemsData.UUIDToProductMap[itemsHash]!!.desc,
                        ItemsData.UUIDToProductMap[itemsHash]!!.price
                    )
                )
            }
            cartList = tempListArray
            binding.cartRV.adapter = CartAdapter(cartList, this)
        })
    }

    private fun prepareDummyData() {

        newList = arrayListOf() // create a list of items
        for (i in ItemsData.dummyProducts.indices) {
            newList.add(
                cartItem(
                    ItemsData.dummyProducts[i].productId,
                    ItemsData.dummyProducts[i].imageId,
                    ItemsData.dummyProducts[i].desc,
                    ItemsData.dummyProducts[i].price
                )
            )
        }

        cartList = arrayListOf() // create list of cart items
    }

    private fun disbaleRecyclerViewScrolling() {
        // to disable scrolling of RV within the scrollview
        binding.itemsRV.isNestedScrollingEnabled = false
    }

    override fun onItemImageClick(position: Int) {
        Toast.makeText(this, "Item image clicked $position", Toast.LENGTH_LONG).show()
        val intent = Intent(this, ItemInformationActivity::class.java)
        startActivity(intent)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onItemButtonClick(position: Int) {

        var flag = 0
        for (items in cartList) {
            if (items.cartUUID == newList[position].UUID) {
                Toast.makeText(this, "Item already present", Toast.LENGTH_LONG).show()
                flag = 1
            }
        }
        if (flag == 0) {
            cartItemsViewModel.addItemsInCart(newList[position].UUID)
        }
    }

    override fun onCartItemButtonClick(position: Int) {
        cartItemsViewModel.deleteCartItem(cartList[position].cartUUID)
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}