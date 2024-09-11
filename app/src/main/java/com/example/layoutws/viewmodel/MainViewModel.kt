package com.example.layoutws.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var number = 0
    private val myLiveData = MutableLiveData(1)

    fun addOne() {
        number++
    }
    fun getCount(): Int {
        return number
    }

    fun getMyLiveData(): MutableLiveData<Int> {
        return myLiveData
    }
    fun setData(data: Int) {
        Log.i("MainViewModel", Thread.currentThread().name)
        myLiveData.postValue(data)
    }
}