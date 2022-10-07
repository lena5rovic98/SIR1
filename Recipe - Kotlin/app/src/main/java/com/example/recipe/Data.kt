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
    private val smizlaCafe = Restaurant("004","Šmizla kafić", "Vizantijski bulevar 17, Niš", listOf())

    private val milk = Foodstuff("Mleko", 60, 3, 5, 3,0, 0)
    private val spaghetti = Foodstuff("Špagete", 220, 8, 1, 1,0, 0)
    private val soda = Foodstuff("Kisela voda", 140, 0, 33, 0,0, 0)
    private val coffee = Foodstuff("Kafa", 0, 0, 0, 0,0, 0)
    private val water = Foodstuff("Voda", 0, 0, 0, 0,0, 0)
    private val apple = Foodstuff("Jabuka", 72, 1, 14, 1,2, 10)
    private val asparagus = Foodstuff("Špargla", 20, 2, 2, 0,10, 15)
    private val broccoli = Foodstuff("Brokoli", 45, 4, 2, 1,6, 220)
    private val carrot = Foodstuff("Šargarepa", 30, 1, 5, 0,110, 10)
    private val cauliflower = Foodstuff("Karfiol", 25, 2, 2, 0,0, 100)
    private val cucumber = Foodstuff("Krastavac", 10, 1, 1, 0,4, 10)
    private val mushrooms = Foodstuff("Pečurke", 20, 3, 0, 2,0, 2)
    private val onion = Foodstuff("Crni luk", 45, 1, 9, 0,0, 20)
    private val orange = Foodstuff("Pomorandža", 47, 1, 9, 1,4, 87)
    private val potato = Foodstuff("Krompir", 110, 3, 1, 0,0, 45)
    private val tomato = Foodstuff("Paradajz", 25, 1, 3, 0,20, 40)

    private val mashedPotatoesIngredients = listOf(potato, milk, water)
    private val mashedPotatoes = Recipe("Krompir pire", "Koristeći blender, polako blenidrati mleko i krompir dok ne postane kremasto i mekano.", 30, 3, Level.EASY, mashedPotatoesIngredients)
    private val grilledMushroomsIngredients = listOf(mushrooms, onion)
    private val grilledMushrooms = Recipe("Grilovane pečurke", "", 25, 2, Level.MEDIUM, grilledMushroomsIngredients)
    private val tomatoSoupIngredients = listOf(tomato, water, cucumber)
    private val tomatoSoup = Recipe("Paradajz supa", "", 50, 6, Level.HARD, tomatoSoupIngredients)
    private val grilledVegetablesIngredients = listOf(asparagus, broccoli, carrot, cauliflower, mushrooms, onion)
    private val grilledVegetables = Recipe("Grilovano povrće", "", 70, 4, Level.HARD, grilledVegetablesIngredients)
    private val fruitSaladIngredients = listOf(apple, orange)
    private val fruitSalad = Recipe("Voćna salata", "", 20, 4, Level.MEDIUM, fruitSaladIngredients)

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

        cookBook.title = "Kuvar"
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
