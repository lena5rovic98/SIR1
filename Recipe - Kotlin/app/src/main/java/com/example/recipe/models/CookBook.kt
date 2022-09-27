package com.example.recipe.models

class CookBook {
    // Example: getter and setter
    var title: String = ""
        get() = field
        set(value) {
            field = value
        }

    var author: String = ""
    var pageCount: Int = 0
    var recipes: MutableList<Recipe>? = mutableListOf()
}
