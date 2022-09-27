package com.example.recipe.enums

enum class Level {
    EASY,
    MEDIUM,
    HARD;

    // Example: semicolon
    // Example: less code
    // Example: return value
    fun getDescription(): String {
        return when (this) {
            EASY -> "This recipe is very easy, you should try"
            MEDIUM -> "This is more complicated, pay attention!"
            HARD -> "Very hard, be careful"
        }
    }
}
