package com.example.layoutws.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.layoutws.data.GlobalCartData
import kotlinx.coroutines.flow.DEFAULT_CONCURRENCY
import kotlin.jvm.internal.MutablePropertyReference

class CartItemsViewModel:ViewModel() {
    private val _cartItemList = MutableLiveData<List<String>>();
    val cartItemsList : LiveData<List<String>> get() = _cartItemList
    private val TAG = "CartItemsViewModel"

    // do operations in private variable _cartItemList
    // observe cartItemsList to get updates
    init {
        Log.i(TAG,"init CartItemsViewModel")
        _cartItemList.value = GlobalCartData.getCartList()
    }
    fun addItemsInCart(itemHash: String){
        GlobalCartData.addToCart(itemHash)
        _cartItemList.value = GlobalCartData.getCartList()
    }
    fun deleteCartItem(itemHash:String){
        GlobalCartData.deleteFromCart(itemHash)
        _cartItemList.value = GlobalCartData.getCartList()
    }
}