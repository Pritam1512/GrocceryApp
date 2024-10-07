package com.example.layoutws.database

import android.util.Log
import com.example.layoutws.R
import java.util.UUID

data class Products(
    val productId: String,
    val imageId: Int,
    val desc: String,
    val price: Float
)
class ItemsData {
    init {
        createAllDummy()
    }
    companion object{
        var UUIDToProductMap:MutableMap<String,Products> =  HashMap<String, Products>()
        var dummyProducts: MutableList<Products> = ArrayList<Products>()

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
            R.drawable.hotel_svgrepo_com,
            R.drawable.avacado_svgrepo_com,
            R.drawable.avacado_food_fruit_svgrepo_com,
            R.drawable.carrot_svgrepo_com,
            R.drawable.cherries_cherry_fruit_food_svgrepo_com,
            R.drawable.cupcake_svgrepo_com,
            R.drawable.milk_svgrepo_com__1_,
            R.drawable.noodles_pasta_svgrepo_com
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
            "Hotel",
            "Avocado",
            "Ripe Avocado",
            "Carrot",
            "Cherries",
            "Cupcake",
            "Milk",
            "Noodles"
        )
        private val price = floatArrayOf(
            12f, 34.5f, 54.7f, 23f, 45.33f, 5f, 56f, 4f, 5.2f, 46f, 67f, 34.6f, 5f, 65f, 76f,4f,6f,7f,5f,1.3f,4.6f
        )


        fun createAllDummy(){
            Log.i(TAG,"Creating Dummy Data...")
            UUIDToProductMap = HashMap<String, Products>()
            dummyProducts = ArrayList<Products>()
            for(i in imageId.indices){
                val uuid = generateUUID();
                val dummyObject = createObject(uuid,i)
                UUIDToProductMap[uuid] = dummyObject
                dummyProducts.add(dummyObject)
            }
            Log.i(TAG,"Map :: ${UUIDToProductMap},${dummyProducts}")
        }
        private fun createObject(UUID: String,i:Int):Products{
            return Products(UUID, imageId[i], description[i], price[i])
        }
        private fun generateUUID():String{
            return UUID.randomUUID().toString()
        }
        private const val TAG = "ItemsData"
    }
}