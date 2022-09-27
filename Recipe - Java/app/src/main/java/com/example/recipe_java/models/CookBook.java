package com.example.recipe_java.models;

import java.util.List;

public class CookBook {
    String title;
    String author;
    Integer pageCount;
    List<Recipe> recipes;

    public CookBook() {

    }

    public CookBook(String title, String author) {
        this.title = title;
        this.author = author;
        this.pageCount = 0;
    }

    // Example: getter and setter
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public void addRecipe(Recipe recipe) {
        this.recipes.add(recipe);
    }
}
