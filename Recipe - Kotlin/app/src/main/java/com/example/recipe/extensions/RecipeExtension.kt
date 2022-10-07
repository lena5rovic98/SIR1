package com.example.recipe.extensions

// Example: extension function
fun Int.getStyledPreparationTime(): String {
    val hours = this / 60
    val minutes = this % 60
    return "Vreme pripreme: ${hours}h i ${minutes}min"
}
