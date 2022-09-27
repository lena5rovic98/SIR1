package com.example.recipe_java.models;

import java.util.List;

public class Restaurant {
    private String id;
    private String name;
    private String address;
    private CookBook cookBook;

    public Restaurant() {}

    public Restaurant(String id, String name, String address, List<Recipe> menu) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public CookBook getCookBook() {
        return cookBook;
    }

    public void setCookBook(CookBook cookBook) {
        this.cookBook = cookBook;
    }

    public int diabetesAcceptableRecipes() {
        int count = 0;
        for (Recipe recipe: cookBook.getRecipes()) {
            if (recipe.isAcceptableForDiabetes()) {
                count++;
            }
        }
        return count;
    }
}
