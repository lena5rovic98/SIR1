package com.example.recipe

import com.example.recipe.models.Restaurant
import com.example.recipe.enums.Level
import com.example.recipe.models.CookBook
import com.example.recipe.models.Foodstuff
import com.example.recipe.models.Recipe

object Data {

    var selectedRestaurant: Restaurant? = null

    val restaurants: MutableList<Restaurant> = mutableListOf()
    val foodstuff: MutableList<Foodstuff> = mutableListOf()
    val cookBook: CookBook = CookBook()

    private val pleasure = Restaurant("001", "Pleasure", "9. бригаде, Ниш", listOf())
    private val irishPub = Restaurant("002","Irish Pub", "Davidova 8, Nis", listOf())
    private val nightAndDay = Restaurant("003","Night and Day", "TPC Kalča Bi-43 bb, Обреновићева, Ниш", listOf())
    private val smizlaCafe = Restaurant("004","Smizla cafe", "Vizantijski bulevar 17, Niš", listOf())

    private val milk = Foodstuff("Milk", 60, 3, 5, 3,0, 0)
    private val spaghetti = Foodstuff("Spaghetti", 220, 8, 1, 1,0, 0)
    private val soda = Foodstuff("Soda", 140, 0, 33, 0,0, 0)
    private val coffee = Foodstuff("Coffee", 0, 0, 0, 0,0, 0)
    private val water = Foodstuff("Water", 0, 0, 0, 0,0, 0)
    private val apple = Foodstuff("Apple", 72, 1, 14, 1,2, 10)
    private val asparagus = Foodstuff("Asparagus", 20, 2, 2, 0,10, 15)
    private val broccoli = Foodstuff("Broccoli", 45, 4, 2, 1,6, 220)
    private val carrot = Foodstuff("Carrot", 30, 1, 5, 0,110, 10)
    private val cauliflower = Foodstuff("Cauliflower", 25, 2, 2, 0,0, 100)
    private val cucumber = Foodstuff("Cucumber", 10, 1, 1, 0,4, 10)
    private val mushrooms = Foodstuff("Mushrooms", 20, 3, 0, 2,0, 2)
    private val onion = Foodstuff("Onion", 45, 1, 9, 0,0, 20)
    private val orange = Foodstuff("Orange", 47, 1, 9, 1,4, 87)
    private val potato = Foodstuff("Potato", 110, 3, 1, 0,0, 45)
    private val tomato = Foodstuff("Tomato", 25, 1, 3, 0,20, 40)

    private val mashedPotatoesIngredients = listOf(potato, milk, water)
    private val mashedPotatoes = Recipe("Mashed Potatoes", "Using a potato masher or electric beater, slowly blend milk mixture into potatoes until smooth and creamy.", 30, 3, Level.EASY, mashedPotatoesIngredients)
    private val grilledMushroomsIngredients = listOf(mushrooms, onion)
    private val grilledMushrooms = Recipe("Grilled Mushrooms", "", 25, 2, Level.MEDIUM, grilledMushroomsIngredients)
    private val tomatoSoupIngredients = listOf(tomato, water, cucumber)
    private val tomatoSoup = Recipe("Tomato soup", "", 50, 6, Level.HARD, tomatoSoupIngredients)
    private val grilledVegetablesIngredients = listOf(asparagus, broccoli, carrot, cauliflower, mushrooms, onion)
    private val grilledVegetables = Recipe("Grilled Vegetables", "", 70, 4, Level.HARD, grilledVegetablesIngredients)
    private val fruitSaladIngredients = listOf(apple, orange)
    private val fruitSalad = Recipe("Fruit Salad", "", 20, 4, Level.MEDIUM, fruitSaladIngredients)

    fun init() {
        foodstuff.add(milk)
        foodstuff.add(spaghetti)
        foodstuff.add(soda)
        foodstuff.add(coffee)
        foodstuff.add(water)
        foodstuff.add(apple)
        foodstuff.add(asparagus)
        foodstuff.add(broccoli)
        foodstuff.add(carrot)
        foodstuff.add(cauliflower)
        foodstuff.add(cucumber)
        foodstuff.add(mushrooms)
        foodstuff.add(onion)
        foodstuff.add(orange)
        foodstuff.add(potato)
        foodstuff.add(tomato)

        cookBook.title = "Cookbook"
        cookBook.author = "Jamie Oliver"
        cookBook.pageCount = 200
        cookBook.recipes = mutableListOf(mashedPotatoes, grilledMushrooms, tomatoSoup, grilledVegetables, fruitSalad)

        pleasure.cookBook = cookBook
        irishPub.cookBook = cookBook
        nightAndDay.cookBook = cookBook
        smizlaCafe.cookBook = cookBook

        restaurants.add(pleasure)
        restaurants.add(irishPub)
        restaurants.add(nightAndDay)
        restaurants.add(smizlaCafe)
    }
}
