package com.example.layoutws.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.layoutws.data.GlobalCartData

class SmallCartItemsViewModel : ViewModel() {
    private val _cartItemList = MutableLiveData<List<String>>();
    val cartItems : LiveData<List<String>> get() = _cartItemList
    private val TAG = "SmallCartItemsViewModel"

    init {
        Log.i(TAG, "SmallCartItemsViewModel created")
        _cartItemList.value = GlobalCartData.getCartList()
    }

    fun addItemsInSmallCart(itemHash: String){
        GlobalCartData.addToCart(itemHash)
        _cartItemList.value = GlobalCartData.getCartList()
    }
}