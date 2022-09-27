package com.example.recipe.ui.launcher

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recipe.Data
import com.example.recipe.R
import com.example.recipe.models.Restaurant
import com.example.recipe.sealedEvents.RestaurantClicked

class RestaurantAdapter(
    private val event: (RestaurantClicked) -> Unit
): RecyclerView.Adapter<RestaurantAdapter.RestaurantViewHolder>() {

    private var restaurants: MutableList<Restaurant> = mutableListOf()

    // Example: predefined argument
    fun setRestaurants(restaurants: MutableList<Restaurant> = Data.restaurants) {
        this.restaurants = restaurants
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant, parent, false)
        return RestaurantViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestaurantViewHolder, position: Int) {
        val restaurant = restaurants[position]
        holder.restaurantName.text = restaurant.name
        holder.restaurantAddress.text = restaurant.address

        holder.itemView.setOnClickListener {
            // Example: sealed event
            event.invoke(RestaurantClicked.RestaurantPicked(restaurant))
        }
    }

    override fun getItemCount(): Int {
        return restaurants.size
    }

    inner class RestaurantViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var restaurantName: TextView = itemView.findViewById(R.id.restaurantNameText)
        var restaurantAddress: TextView = itemView.findViewById(R.id.restaurantAddressText)
    }
}
