package com.example.recipe.ui.launcher

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe.Data
import com.example.recipe.MainActivity
import com.example.recipe.R
import com.example.recipe.sealedEvents.RestaurantClicked

class LauncherActivity: AppCompatActivity() {

    private lateinit var restaurantRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

        initData()
    }

    private fun initData() {
        Data.init()

        restaurantRecyclerView = findViewById(R.id.restaurantsRecyclerView)
        restaurantRecyclerView.adapter = RestaurantAdapter {
            // Example: sealed event
            when (it) {
                is RestaurantClicked.RestaurantPicked -> {
                    val intent = Intent(this, MainActivity::class.java)
                    Data.selectedRestaurant = it.restaurant
                    startActivity(intent)
                }
            }
        }
        // Example: predefined argument
        (restaurantRecyclerView.adapter as RestaurantAdapter).setRestaurants()
        (restaurantRecyclerView.adapter as RestaurantAdapter).setRestaurants(Data.restaurants)
    }
}

