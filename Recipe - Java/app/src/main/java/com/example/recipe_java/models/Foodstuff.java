package com.example.recipe_java.models;

public class Foodstuff {
    // Example: semicolon
    private String name;
    private Integer calories; //Calories in kilocalories.
    private Integer protein; //Protein amount in grams.
    private Integer sugar; //Sugar or glucose amount in grams.
    private Integer fats; //Total fat amount in grams.
    private Integer vitaminA; //Vitamin A amount in percent.
    private Integer vitaminC; //Vitamin C amount in percent.

    public Foodstuff(String name, int calories, int protein, int sugar, int fats, int vitaminA, int vitaminC) {
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.sugar = sugar;
        this.fats = fats;
        this.vitaminA = vitaminA;
        this.vitaminC = vitaminC;
    }

    public String getName() {
        return name;
    }

    public Integer getCalories() {
        return calories;
    }

    public Integer getProtein() {
        return protein;
    }

    public Integer getFats() {
        return fats;
    }

    public boolean isGoodForDiabetics() {
        return sugar < 3;
    }

    static public int convertKcalToCal(int kcal) {
        return kcal * 1000;
    }

    static public Foodstuff moreHealthier(Foodstuff foodstuff1, Foodstuff foodstuff2) {
        if (foodstuff1.calories < foodstuff2.calories && foodstuff1.protein > foodstuff2.protein) {
            return foodstuff1;
        } else return foodstuff2;
    }
}
