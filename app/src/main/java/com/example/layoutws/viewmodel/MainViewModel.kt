package com.example.layoutws.viewmodel

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var number = 0

    fun addOne() {
        number++
    }
    fun getCount(): Int {
        return number
    }
}