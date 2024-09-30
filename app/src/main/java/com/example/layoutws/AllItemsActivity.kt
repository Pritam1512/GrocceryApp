package com.example.layoutws

import android.app.Activity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.layoutws.adapters.ItemsAdapter
import com.example.layoutws.data.cartItem
import com.example.layoutws.database.ItemsData
import com.example.layoutws.databinding.AllItemActivityBinding
import com.example.layoutws.viewmodel.CartItemsViewModel

class AllItemsActivity: Activity(),ItemsAdapter.OnItemClickListener {

    private lateinit var binding:AllItemActivityBinding
    private lateinit var newList: ArrayList<cartItem>
    
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        binding = AllItemActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ItemsData.createAllDummy()
        prepareDummyData()
        setAllItemAdapters()
        handleCartButtonVisibility()
        disbaleRecyclerViewScrolling()
    }

    private fun setAllItemAdapters() {
        Log.i(TAG,"Setting up adapter and layout manager for all items recycler view.")
        Log.i(TAG,"NewList $newList")
        val mAdapater = ItemsAdapter(newList, this)
        val gridLayoutManager = GridLayoutManager(this, 3)
        binding.allItemsRV.layoutManager = gridLayoutManager
        binding.allItemsRV.setHasFixedSize(true)
        binding.allItemsRV.adapter = mAdapater
    }
    
    private fun prepareDummyData() {
        Log.i(TAG, "Preparing dummy data for all items.${ItemsData.dummyProducts.size}")
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
        Log.i(TAG, "NewList $newList")
    }
    private fun disbaleRecyclerViewScrolling() {
        // to disable scrolling of RV within the scrollview
        binding.allItemsRV.isNestedScrollingEnabled = false
    }
    private fun handleCartButtonVisibility(){
        binding.floatingCartButton
    }
    override fun onItemImageClick(position: Int) {
        Log.i(TAG,"Image Clicked at position $position")
    }
    override fun onItemButtonClick(position: Int) {
        Log.i(TAG,"Button Clicked at position $position")
    }

    companion object{
        private const val TAG = "AllItemsActivity"
    }
}