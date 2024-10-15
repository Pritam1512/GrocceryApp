package com.example.layoutws.data

import android.util.Log

object GlobalCartData {

    // array list of string of object hash
    private var cartList: ArrayList<String> = ArrayList()
    private const val TAG = "GlobalCartData"

    init {
        Log.i(TAG,"Singleton init $cartList")
    }

    fun getCartList() : ArrayList<String> {
        return cartList
    }
    fun addToCart(itemHash: String) {
        cartList.add(itemHash)
    }

    fun deleteFromCart(itemHash: String){
        cartList.remove(itemHash)
    }
}