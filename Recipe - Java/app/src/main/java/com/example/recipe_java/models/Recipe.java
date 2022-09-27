package com.example.recipe_java.models;

import com.example.recipe_java.enums.Level;
import org.jetbrains.annotations.NotNull;
import java.util.List;

public class Recipe {
    final public String name;
    private String description;
    private Integer preparationTime; // in minutes
    private Integer serves;
    private Level level;
    private List<Foodstuff> ingredients;

    public Recipe(String name) {
        this.name = name;
    }

    public Recipe(String name, String description, Integer preparationTime, Integer serves, Level level,
                  List<Foodstuff> ingredients) {
        this.name = name;
        this.description = description;
        this.preparationTime = preparationTime;
        this.serves = serves;
        this.level = level;
        this.ingredients = ingredients;
    }

    @NotNull
    @Override
    public String toString() {
        // Example: null safety
        if (name != null && description != null) {
            // Example: string template
            return "Recipe [name=" + name + ", description=" + description + ", preparationTime=" + preparationTime +
                    ", serves=" + serves + ", level=" + level + "]";
        } else {
            return "";
        }
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(Integer preparationTime) {
        this.preparationTime = preparationTime;
    }

    public Integer getServes() {
        return serves;
    }

    public void setServes(Integer serves) {
        this.serves = serves;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public List<Foodstuff> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Foodstuff> ingredients) {
        this.ingredients = ingredients;
    }

    public String getStyledPreparationTime() {
        int hours = preparationTime / 60;
        int minutes = preparationTime % 60;
        return "Preparation time: " + hours + "h and " + minutes + "min";
    }

    public Boolean isAcceptableForDiabetes() {
        int caloriesCount = 0;
        if (ingredients != null) {
            for (Foodstuff ingredient : ingredients) {
                caloriesCount += ingredient.getCalories();
            }
        }
        return caloriesCount <= 10;
    }
}
