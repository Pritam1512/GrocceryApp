package com.example.layoutws.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemCountViewModel : ViewModel() {
    private var number = 1
    private val myLiveData = MutableLiveData(1)

    fun addOne() {
        number++
        setData()
    }
    fun subtractOne() {
        number--
        setData()
    }
    fun getMyLiveData(): MutableLiveData<Int> {
        return myLiveData
    }
    private fun setData() {
        myLiveData.postValue(number)
    }
    fun setDefaultValue(){
        number=1
        myLiveData.postValue(1)
    }
}