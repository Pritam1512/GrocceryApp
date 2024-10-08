package com.example.layoutws

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.layoutws.adapters.CartAdapter
import com.example.layoutws.adapters.ItemsAdapter
import com.example.layoutws.data.SingleCartItems
import com.example.layoutws.data.cartItem
import com.example.layoutws.database.ItemsData
import com.example.layoutws.databinding.AllItemActivityBinding
import com.example.layoutws.viewmodel.CartItemsViewModel
import com.example.layoutws.viewmodel.SmallCartItemsViewModel

class AllItemsActivity: AppCompatActivity(),ItemsAdapter.OnItemClickListener {

    private lateinit var binding:AllItemActivityBinding
    private lateinit var newList: ArrayList<cartItem>
    private val smallCartItemsViewModel : SmallCartItemsViewModel by viewModels<SmallCartItemsViewModel>()
    private lateinit var smallCartHashSet: HashSet<String>
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        binding = AllItemActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ItemsData.funCreateAllDummy()
        smallCartHashSet = HashSet()

        prepareDummyData()
        setAllItemAdapters()
        handleCartButtonVisibility()
        disbaleRecyclerViewScrolling()
        setUpSmallCartObservers()

        binding.floatingCartView.setOnClickListener {
            Log.i(TAG,"Floating cart clicked, ${smallCartItemsViewModel.getSmallCartItemArray()}")
            val cartActivityIntent = Intent(this, MainActivity::class.java)
            cartActivityIntent.putExtra("items_hash_array",smallCartItemsViewModel.getSmallCartItemArray())
            startActivity(cartActivityIntent)
        }
    }
    private fun setUpSmallCartObservers() {
        smallCartItemsViewModel.getSmallCartItems().observe(this, Observer {
            Log.i("MainActivity", ":: small Cart data changed")
            if(it.isNotEmpty()){
                binding.floatingCartView.visibility = View.VISIBLE
            }
            for(itemhash in it){
                Log.i(TAG,"Item ${ItemsData.UUIDToProductMap[itemhash]}")
            }
        })
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
        Log.i(TAG, " Map :: ${ItemsData.UUIDToProductMap}")
    }
    private fun disbaleRecyclerViewScrolling() {
        // to disable scrolling of RV within the scrollview
        binding.allItemsRV.isNestedScrollingEnabled = false
    }
    private fun handleCartButtonVisibility(){
        binding.floatingCartView.visibility = View.GONE
    }
    override fun onItemImageClick(position: Int) {
        Log.i(TAG,"Image Clicked at position $position")
        // start ItemInfo activity with item hash
    }
    override fun onItemButtonClick(position: Int) {
        Log.i(TAG,"Button Clicked at position $position")
        // add this item to smallcartviewmodel

        if (!smallCartHashSet.contains(newList[position].UUID)) {
            binding.floatingCartImage.setImageResource(newList[position].imageID)
            smallCartItemsViewModel.addItemsInSmallCart(newList[position].UUID)
            smallCartHashSet.add(newList[position].UUID)
        } else {
            Toast.makeText(this, "Item already present", Toast.LENGTH_LONG).show()
        }
    }

    companion object{
        private const val TAG = "AllItemsActivity"
    }
}