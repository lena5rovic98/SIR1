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

    static private Foodstuff milk = new Foodstuff("Mleko", 60, 3, 5, 3,0, 0);
    static private Foodstuff spaghetti = new Foodstuff("Špagete", 220, 8, 1, 1,0, 0);
    static private Foodstuff soda = new Foodstuff("Kisela voda", 140, 0, 33, 0,0, 0);
    static private Foodstuff coffee = new Foodstuff("Kafa", 0, 0, 0, 0,0, 0);
    static private Foodstuff water = new Foodstuff("Voda", 0, 0, 0, 0,0, 0);
    static private Foodstuff apple = new Foodstuff("Jabuka", 72, 1, 14, 1,2, 10);
    static private Foodstuff asparagus = new Foodstuff("Špargla", 20, 2, 2, 0,10, 15);
    static private Foodstuff broccoli = new Foodstuff("Brokoli", 45, 4, 2, 1,6, 220);
    static private Foodstuff carrot = new Foodstuff("Šargarepa", 30, 1, 5, 0,110, 10);
    static private Foodstuff cauliflower = new Foodstuff("Karfiol", 25, 2, 2, 0,0, 100);
    static private Foodstuff cucumber = new Foodstuff("Krastavac", 10, 1, 1, 0,4, 10);
    static private Foodstuff mushrooms = new Foodstuff("Pečurke", 20, 3, 0, 2,0, 2);
    static private Foodstuff onion = new Foodstuff("Crni luk", 45, 1, 9, 0,0, 20);
    static private Foodstuff orange = new Foodstuff("Pomorandža", 47, 1, 9, 1,4, 87);
    static private Foodstuff potato = new Foodstuff("Krompir", 110, 3, 1, 0,0, 45);
    static private Foodstuff tomato = new Foodstuff("Paradajz", 25, 1, 3, 0,20, 40);

    static private List<Foodstuff> mashedPotatoesIngredients = Arrays.asList(potato, milk, water);
    static private List<Foodstuff> grilledMushroomsIngredients = Arrays.asList(mushrooms, onion);
    static private List<Foodstuff> tomatoSoupIngredients = Arrays.asList(tomato, water, cucumber);
    static private List<Foodstuff> grilledVegetablesIngredients = Arrays.asList(asparagus, broccoli, carrot, cauliflower, mushrooms, onion);
    static private List<Foodstuff> fruitSaladIngredients = Arrays.asList(apple, orange);

    static private Recipe mashedPotatoes = new Recipe("Krompir pire", "Koristeći blender, polako blenidrati mleko i krompir dok ne postane kremasto i mekano.", 30, 3, Level.EASY, mashedPotatoesIngredients);
    static private Recipe grilledMushrooms = new Recipe("Grilovane pečurke", "", 25, 2, Level.MEDIUM, grilledMushroomsIngredients);
    static private Recipe tomatoSoup = new Recipe("Paradajz supa", "", 50, 6, Level.HARD, tomatoSoupIngredients);
    static private Recipe grilledVegetables = new Recipe("Grilovano povrće", "", 70, 4, Level.HARD, grilledVegetablesIngredients);
    static private Recipe fruitSalad = new Recipe("Voćna salata", "", 20, 4, Level.MEDIUM, fruitSaladIngredients);

    static private Restaurant pleasure = new Restaurant("001", "Pleasure", "9. бригаде, Ниш", null);
    static private Restaurant irishPub = new Restaurant("002","Irish Pub", "Davidova 8, Nis", null);
    static private Restaurant nightAndDay = new Restaurant("003","Night and Day", "TPC Kalča Bi-43 bb, Обреновићева, Ниш", null);
    static private Restaurant smizlaCafe = new Restaurant("004","Šmizla kafić", "Vizantijski bulevar 17, Niš", null);

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

        cookBook.setTitle("Kuvar");
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
