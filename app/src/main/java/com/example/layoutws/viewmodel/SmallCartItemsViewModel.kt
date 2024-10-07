package com.example.layoutws.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SmallCartItemsViewModel : ViewModel() {
    private var cartItemList = MutableLiveData<List<String>>();
    private var cartItems = ArrayList<String>()


    fun addItemsInSmallCart(itemHash: String){
        cartItems.add(itemHash)
        cartItemList.postValue(cartItems)

    }
    fun getSmallCartItems() : MutableLiveData<List<String>> {
        return cartItemList
    }
    fun getSmallCartItemArray() : ArrayList<String>{
        return cartItems
    }
    fun deleteSmallCartItem(itemHash:String){
        cartItems.remove(itemHash)
        cartItemList.postValue(cartItems)
    }
    fun clearSmallCart(){
        cartItems.clear()
        cartItemList.postValue(cartItems)
    }
}