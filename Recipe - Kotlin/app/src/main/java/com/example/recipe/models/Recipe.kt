package com.example.recipe.models

import com.example.recipe.enums.Level

data class Recipe(
    // Example: null safety
    val name: String,
    var description: String?,
    var preparationTime: Int, // in minutes
    var serves: Int,
    var level: Level,
    var ingredients: List<Foodstuff>?,
) {
    lateinit var similarRecipes: ArrayList<Recipe>

    fun isSimilarRecipesInitialized(): Boolean {
        return this::similarRecipes.isInitialized
    }

    fun isAcceptableForDiabetes(): Boolean {
        var caloriesCount = 0;
        for (ingredient in ingredients!!) {
            caloriesCount += ingredient.calories
        }
        return caloriesCount <= 10
    }
}
