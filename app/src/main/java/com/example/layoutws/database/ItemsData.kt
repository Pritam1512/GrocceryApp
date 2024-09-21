package com.example.layoutws.database

import com.example.layoutws.R
import java.util.UUID

data class Products(
    val productId: String,
    val imageId: Int,
    val desc: String,
    val price: Float
)
class ItemsData {
    companion object{
        private val imageId = intArrayOf(
            R.drawable.chicken_food_thanksgiving_svgrepo_com,
            R.drawable.apple_svgrepo_com,
            R.drawable.banana_svgrepo_com__1_,
            R.drawable.burger_1_svgrepo_com,
            R.drawable.chips_snack_svgrepo_com,
            R.drawable.coke_svgrepo_com,
            R.drawable.cookies_svgrepo_com,
            R.drawable.fish_svgrepo_com,
            R.drawable.fries_svgrepo_com,
            R.drawable.tomato_svgrepo_com,
            R.drawable.pizza_svgrepo_com,
            R.drawable.omelette_svgrepo_com,
            R.drawable.rice_svgrepo_com,
            R.drawable.hotel_svgrepo_com
        )
        private val description = arrayOf(
            "Chicken",
            "Apple",
            "Banana",
            "Burger",
            "Chips",
            "Coke",
            "Cookies",
            "Fish",
            "Fries",
            "Tomato",
            "Pizza",
            "Omelette",
            "rice",
            "Hotel"
        )
        private val price = floatArrayOf(
            12f, 34.5f, 54.7f, 23f, 45.33f, 5f, 56f, 4f, 5.2f, 46f, 67f, 34.6f, 5f, 65f
        )
        val dummyProducts = listOf(
            Products(generateUUID(), imageId[0], description[0], price[0]),
            Products(generateUUID(), imageId[1], description[1], price[1]),
            Products(generateUUID(), imageId[2], description[2], price[2]),
            Products(generateUUID(), imageId[3], description[3], price[3]),
            Products(generateUUID(), imageId[4], description[4], price[4]),
            Products(generateUUID(), imageId[5], description[5], price[5]),
            Products(generateUUID(), imageId[6], description[6], price[6]),
            Products(generateUUID(), imageId[7], description[7], price[7]),
            Products(generateUUID(), imageId[8], description[8], price[8]),
            Products(generateUUID(), imageId[9], description[9], price[9]),
            Products(generateUUID(), imageId[10], description[10], price[10]),
            Products(generateUUID(), imageId[11], description[11], price[11]),
            Products(generateUUID(), imageId[12], description[12], price[12]),
            Products(generateUUID(), imageId[13], description[13], price[13]),
        )
        private fun generateUUID():String{
            return UUID.randomUUID().toString()
        }
    }
}