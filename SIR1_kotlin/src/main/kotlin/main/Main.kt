package main

import enums.Level
import extensions.getStyledPreparationTime
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import models.CookBook
import models.Foodstuff
import models.Recipe
import Restaurant

fun main() {
    val milk = Foodstuff("Milk", 60, 3, 5, 3,0, 0)
    val spaghetti = Foodstuff("Spaghetti", 220, 8, 1, 1,0, 0)
    val soda = Foodstuff("Soda", 140, 0, 33, 0,0, 0)
    val coffee = Foodstuff("Coffee", 0, 0, 0, 0,0, 0)
    val water = Foodstuff("Water", 0, 0, 0, 0,0, 0)
    val apple = Foodstuff("Apple", 72, 1, 14, 1,2, 10)
    val asparagus = Foodstuff("Asparagus", 20, 2, 2, 0,10, 15)
    val broccoli = Foodstuff("Broccoli", 45, 4, 2, 1,6, 220)
    val carrot = Foodstuff("Carrot", 30, 1, 5, 0,110, 10)
    val cauliflower = Foodstuff("Cauliflower", 25, 2, 2, 0,0, 100)
    val cucumber = Foodstuff("Cucumber", 10, 1, 1, 0,4, 10)
    val mushrooms = Foodstuff("Mushrooms", 20, 3, 0, 2,0, 2)
    val onion = Foodstuff("Onion", 45, 1, 9, 0,0, 20)
    val orange = Foodstuff("Orange", 47, 1, 9, 1,4, 87)
    val potato = Foodstuff("Potato", 110, 3, 1, 0,0, 45)
    val tomato = Foodstuff("Tomato", 25, 1, 3, 0,20, 40)

    val mashedPotatoesIngredients = listOf(potato, milk, water)
    val mashedPotatoes = Recipe("Mashed Potatoes", " Using a potato masher or electric beater, slowly blend milk mixture into potatoes until smooth and creamy.", 30, 3, Level.EASY, mashedPotatoesIngredients)
    val grilledMushroomsIngredients = listOf(mushrooms, onion)
    val grilledMushrooms = Recipe("Grilled Mushrooms", "", 25, 2, Level.MEDIUM, grilledMushroomsIngredients)
    val tomatoSoupIngredients = listOf(tomato, water, cucumber)
    val tomatoSoup = Recipe("Tomato soup", "", 50, 6, Level.HARD, tomatoSoupIngredients)
    val grilledVegetablesIngredients = listOf(asparagus, broccoli, carrot, cauliflower, mushrooms, onion)
    val grilledVegetables = Recipe("Grilled Vegetables", "", 70, 4, Level.HARD, grilledVegetablesIngredients)
    val fruitSaladIngredients = listOf(apple, orange)
    val fruitSalad = Recipe("Fruit Salad", "", 20, 4, Level.MEDIUM, fruitSaladIngredients)

    fun getRandomRecipeForMeal(meal: String): Recipe? {
        return when (meal) {
            "breakfast" -> fruitSalad
            "snack" -> tomatoSoup
            "lunch" -> mashedPotatoes
            else -> null
        }
    }

    val randomRecipe = getRandomRecipeForMeal("lunch")
    println(randomRecipe?.name)

    // Enum, ;
    val desc = Level.HARD.getDescription()

    // Null safety
    // val description: String? = null
    val description: String? = "Description"
    println(description!!)

    val recipeDescription: String? = null
    // val foodstuffDescription: String = null

    println(recipeDescription?.length)

    val mashedPotatoesFirstIngredientCalories = mashedPotatoes?.ingredients?.firstOrNull()?.calories

    // Extension function
    val mashedPotatoesTime = mashedPotatoes.preparationTime.getStyledPreparationTime()
    println(mashedPotatoesTime)

    // Data class
    fruitSalad.description = "Edited description for fruit salad"
    println(fruitSalad.description)

    println(fruitSalad.toString())

    // val vs var
    val newRecipe: Recipe = Recipe("Spaghetti", "", 50, 4, Level.HARD,
        listOf(spaghetti))

//    newRecipe = Recipe("Orange soda", "", 10, 1, Level.EASY,
//        listOf(orange, soda))

    var orangeSoda: Recipe = Recipe("Spaghetti", "", 50, 4, Level.HARD,
        listOf(spaghetti))

    orangeSoda = Recipe("Orange soda", "", 10, 1, Level.EASY,
        listOf(orange, soda))

    // orangeSoda.name = "Orange soda juice"
    orangeSoda.description = "Squeeze orange and add soda"

    // String templates

    val fruitSaladDescription = "Food salad description is: ${fruitSalad.description}, and it is for ${fruitSalad.serves} people"
    val fruitSaladPrepTime = "Fruit salad prep time: ${fruitSalad.preparationTime.getStyledPreparationTime()}"
    val fruitSaladServes = "Fruit salad serves: ${fruitSalad.serves * 2} "

    // val n = 10
    val n = -10
    val message = "$n is ${if(n > 0) "positive" else "not positive"}"
    println(message)

    val price = 50
    println("Price is ${price}\$")

    // lateinit

//    val fruitSaladSimilarRecipes = fruitSalad.similarRecipes
//    println(fruitSaladSimilarRecipes.first())

    fruitSalad.similarRecipes = arrayListOf(orangeSoda)

    if (fruitSalad.isSimilarRecipesInitialized())  {
        println(fruitSalad.similarRecipes.first())
    }

    // companion object
    val healthier = Foodstuff.moreHealthier(orange, soda)
    println(healthier.name)

    println("Milk for diabetics: ${milk.isGoodForDiabetics()}")

    // getters-setters
    val cookBook = CookBook()
    cookBook.title = "Serbian cook book" // access setter
    println(cookBook.title)                // access getter


    // elvis operator
    val recipeCount = if (cookBook.recipes != null) cookBook.recipes!!.size else 0
    val recipeCountElvis = cookBook.recipes?.size ?: 0

    // coroutines
    GlobalScope.launch {
        delay(2000)
        println("World")
    }
    println("Hello")
    Thread.sleep(3000)

    // collection functions
    val mashedPotatoesString = mashedPotatoes.ingredients?.joinToString(
        separator = ", ",
        prefix = "Mashed potatoes ingredients: "
    ) { it.name }

    println(mashedPotatoesString)

    val mashedPotatoesFilter = mashedPotatoes.ingredients?.filter {
        return@filter !it.isGoodForDiabetics()
    }
    println("Bad for diabetics: $mashedPotatoesFilter")

    cookBook.recipes = listOf(grilledMushrooms, grilledVegetables, orangeSoda)

    val sortedRecipesByPrepTime = cookBook.recipes?.sortedBy {
        it.preparationTime
    }
    val sortedDescendingRecipesByPrepTime = cookBook.recipes?.sortedByDescending {
        it.preparationTime
    }
    println(sortedRecipesByPrepTime?.joinToString { it.name })
    println(sortedDescendingRecipesByPrepTime?.joinToString { it.name })

    cookBook.recipes?.map { it.preparationTime += 1 }
    println(cookBook.recipes?.joinToString { it.preparationTime.toString() })

    val orangeRecipes = cookBook.recipes?.find {
        return@find it.name.contains("Orange")
    }

    println(orangeRecipes)

    when (val a = Foodstuff.convertKcalToCal(43)) {
        43000 -> println("true")
        43 -> println("false")
    }

    val restaurant = Restaurant(
        "Serbian restaurant", "Address 1, Belgrade",
        listOf(grilledMushrooms, grilledVegetables, orangeSoda, mashedPotatoes, tomatoSoup, fruitSalad)
    )
    println("Restaurant \"${restaurant.name}\" has ${restaurant.diabetesAcceptableRecipes()} recipes that are acceptable for diabetics." )

    val variable: Any = 10f
    if (variable is Int) {
        println("Variable is int")
    } else if (variable is Float) {
        println("Variable is float")
    }

    val newVariable = (variable as Float).plus(10f)
    println(newVariable)
}
