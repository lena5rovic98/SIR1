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
            EASY -> "Recept je veoma jednostavan, trebalo bi da probaš"
            MEDIUM -> "Veoma teško, budi pažljiv"
            HARD -> "Ovo je komplikovanije, obrati pažnju!"
        }
    }
}
