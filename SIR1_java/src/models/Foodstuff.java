package models;

public class Foodstuff {
    String name;
    Integer calories; //Calories in kilocalories.
    Integer protein; //Protein amount in grams.
    Integer sugar; //Sugar or glucose amount in grams.
    Integer fats; //Total fat amount in grams.
    Integer vitaminA; //Vitamin A amount in percent.
    Integer vitaminC; //Vitamin C amount in percent.

    public Foodstuff(String name, Integer calories, Integer protein, Integer sugar, Integer fats, Integer vitaminA, Integer vitaminC) {
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.sugar = sugar;
        this.fats = fats;
        this.vitaminA = vitaminA;
        this.vitaminC = vitaminC;
    }

    public Integer getCalories() {
        return calories;
    }

    public String getName() {
        return name;
    }

    public static Foodstuff moreHealthier(Foodstuff foodstuff1, Foodstuff foodstuff2) {
        if (foodstuff1.calories < foodstuff2.calories && foodstuff1.protein > foodstuff2.protein) {
            return foodstuff1;
        } else return foodstuff2;
    }

    public boolean isGoodForDiabetics() {
        return sugar < 3;
    }
}
