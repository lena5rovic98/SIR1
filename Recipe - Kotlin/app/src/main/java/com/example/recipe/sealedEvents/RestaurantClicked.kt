package com.example.recipe.sealedEvents

import com.example.recipe.models.Restaurant

// Example: sealed event
sealed class RestaurantClicked {
    data class RestaurantPicked(val restaurant: Restaurant): RestaurantClicked()
}
