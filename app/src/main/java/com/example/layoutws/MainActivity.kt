package com.example.layoutws

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import com.example.layoutws.databinding.ActivityMainBinding
import com.example.layoutws.databinding.SingleProductItemBinding
import com.example.layoutws.databinding.SubitemLayoutBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: SingleProductItemBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = SingleProductItemBinding.inflate(layoutInflater) // inflate the layout
        setContentView(binding.root)


    }
}