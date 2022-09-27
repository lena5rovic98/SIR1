package com.example.recipe_java;

import com.example.recipe_java.enums.Level;
import com.example.recipe_java.models.CookBook;
import com.example.recipe_java.models.Foodstuff;
import com.example.recipe_java.models.Recipe;
import com.example.recipe_java.models.Restaurant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Data {

    static public Restaurant selectedRestaurant = new Restaurant();

    static public ArrayList<Foodstuff> foodstuff = new ArrayList<Foodstuff>();
    static public CookBook cookBook = new CookBook();
    static public ArrayList<Restaurant> restaurants = new ArrayList<>();

    static private Foodstuff milk = new Foodstuff("Milk", 60, 3, 5, 3,0, 0);
    static private Foodstuff spaghetti = new Foodstuff("Spaghetti", 220, 8, 1, 1,0, 0);
    static private Foodstuff soda = new Foodstuff("Soda", 140, 0, 33, 0,0, 0);
    static private Foodstuff coffee = new Foodstuff("Coffee", 0, 0, 0, 0,0, 0);
    static private Foodstuff water = new Foodstuff("Water", 0, 0, 0, 0,0, 0);
    static private Foodstuff apple = new Foodstuff("Apple", 72, 1, 14, 1,2, 10);
    static private Foodstuff asparagus = new Foodstuff("Asparagus", 20, 2, 2, 0,10, 15);
    static private Foodstuff broccoli = new Foodstuff("Broccoli", 45, 4, 2, 1,6, 220);
    static private Foodstuff carrot = new Foodstuff("Carrot", 30, 1, 5, 0,110, 10);
    static private Foodstuff cauliflower = new Foodstuff("Cauliflower", 25, 2, 2, 0,0, 100);
    static private Foodstuff cucumber = new Foodstuff("Cucumber", 10, 1, 1, 0,4, 10);
    static private Foodstuff mushrooms = new Foodstuff("Mushrooms", 20, 3, 0, 2,0, 2);
    static private Foodstuff onion = new Foodstuff("Onion", 45, 1, 9, 0,0, 20);
    static private Foodstuff orange = new Foodstuff("Orange", 47, 1, 9, 1,4, 87);
    static private Foodstuff potato = new Foodstuff("Potato", 110, 3, 1, 0,0, 45);
    static private Foodstuff tomato = new Foodstuff("Tomato", 25, 1, 3, 0,20, 40);

    static private List<Foodstuff> mashedPotatoesIngredients = Arrays.asList(potato, milk, water);
    static private List<Foodstuff> grilledMushroomsIngredients = Arrays.asList(mushrooms, onion);
    static private List<Foodstuff> tomatoSoupIngredients = Arrays.asList(tomato, water, cucumber);
    static private List<Foodstuff> grilledVegetablesIngredients = Arrays.asList(asparagus, broccoli, carrot, cauliflower, mushrooms, onion);
    static private List<Foodstuff> fruitSaladIngredients = Arrays.asList(apple, orange);

    static private Recipe mashedPotatoes = new Recipe("Mashed Potatoes", "Using a potato masher or electric beater, slowly blend milk mixture into potatoes until smooth and creamy.", 30, 3, Level.EASY, mashedPotatoesIngredients);
    static private Recipe grilledMushrooms = new Recipe("Grilled Mushrooms", "", 25, 2, Level.MEDIUM, grilledMushroomsIngredients);
    static private Recipe tomatoSoup = new Recipe("Tomato soup", "", 50, 6, Level.HARD, tomatoSoupIngredients);
    static private Recipe grilledVegetables = new Recipe("Grilled Vegetables", "", 70, 4, Level.HARD, grilledVegetablesIngredients);
    static private Recipe fruitSalad = new Recipe("Fruit Salad", "", 20, 4, Level.MEDIUM, fruitSaladIngredients);

    static private Restaurant pleasure = new Restaurant("001", "Pleasure", "9. бригаде, Ниш", null);
    static private Restaurant irishPub = new Restaurant("002","Irish Pub", "Davidova 8, Nis", null);
    static private Restaurant nightAndDay = new Restaurant("003","Night and Day", "TPC Kalča Bi-43 bb, Обреновићева, Ниш", null);
    static private Restaurant smizlaCafe = new Restaurant("004","Smizla cafe", "Vizantijski bulevar 17, Niš", null);

    static public void init() {
        foodstuff.add(milk);
        foodstuff.add(spaghetti);
        foodstuff.add(soda);
        foodstuff.add(coffee);
        foodstuff.add(water);
        foodstuff.add(apple);
        foodstuff.add(asparagus);
        foodstuff.add(broccoli);
        foodstuff.add(carrot);
        foodstuff.add(cauliflower);
        foodstuff.add(cucumber);
        foodstuff.add(mushrooms);
        foodstuff.add(onion);
        foodstuff.add(orange);
        foodstuff.add(potato);
        foodstuff.add(tomato);

        cookBook.setTitle("Cookbook");
        cookBook.setAuthor("Jamie Oliver");
        cookBook.setPageCount(200);
        cookBook.setRecipes(Arrays.asList(mashedPotatoes, grilledMushrooms, tomatoSoup, grilledVegetables, fruitSalad));

        pleasure.setCookBook(cookBook);
        irishPub.setCookBook(cookBook);
        nightAndDay.setCookBook(cookBook);
        smizlaCafe.setCookBook(cookBook);

        restaurants.add(pleasure);
        restaurants.add(irishPub);
        restaurants.add(nightAndDay);
        restaurants.add(smizlaCafe);
    }
}
