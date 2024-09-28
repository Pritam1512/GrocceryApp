package com.example.layoutws.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.jvm.internal.MutablePropertyReference

class CartItemsViewModel:ViewModel() {
    private var cartItemList = MutableLiveData<List<String>>();
    private var cartItems = ArrayList<String>()

    fun addItemsInCart(itemHash: String){
        cartItems.add(itemHash)
        cartItemList.postValue(cartItems)

    }
    fun getCartItems() : MutableLiveData<List<String>>{
        return cartItemList
    }
    fun deleteCartItem(itemHash:String){
        cartItems.remove(itemHash)
        cartItemList.postValue(cartItems)
    }
    fun clearCart(){
        cartItems.clear()
        cartItemList.postValue(cartItems)
    }
}