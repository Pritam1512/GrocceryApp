package com.example.layoutws

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.layoutws.databinding.IndividualItemInformationLayoutBinding

class ItemInformationActivity : AppCompatActivity() {

    private lateinit var binding: IndividualItemInformationLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = IndividualItemInformationLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i(TAG,"OnCreate called")
    }
    companion object{
        const val TAG = "ItemInformationActivity"
    }
}