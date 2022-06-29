import enums.Level;
import models.CookBook;
import models.Foodstuff;
import models.Recipe;
import models.Restaurant;
import org.omg.CORBA.Any;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    static Foodstuff milk = new Foodstuff("Milk", 60, 3, 5, 3,0, 0);
    static Foodstuff spaghetti = new Foodstuff("Spaghetti", 220, 8, 1, 1,0, 0);
    static Foodstuff soda = new Foodstuff("Soda", 140, 0, 33, 0,0, 0);
    static Foodstuff coffee = new Foodstuff("Coffee", 0, 0, 0, 0,0, 0);
    static Foodstuff water = new Foodstuff("Water", 0, 0, 0, 0,0, 0);
    static Foodstuff apple = new Foodstuff("Apple", 72, 1, 14, 1,2, 10);
    static Foodstuff asparagus = new Foodstuff("Asparagus", 20, 2, 2, 0,10, 15);
    static Foodstuff broccoli = new Foodstuff("Broccoli", 45, 4, 2, 1,6, 220);
    static Foodstuff carrot = new Foodstuff("Carrot", 30, 1, 5, 0,110, 10);
    static Foodstuff cauliflower = new Foodstuff("Cauliflower", 25, 2, 2, 0,0, 100);
    static Foodstuff cucumber = new Foodstuff("Cucumber", 10, 1, 1, 0,4, 10);
    static Foodstuff mushrooms = new Foodstuff("Mushrooms", 20, 3, 0, 2,0, 2);
    static Foodstuff onion = new Foodstuff("Onion", 45, 1, 9, 0,0, 20);
    static Foodstuff orange = new Foodstuff("Orange", 47, 1, 9, 1,4, 87);
    static Foodstuff potato = new Foodstuff("Potato", 110, 3, 1, 0,0, 45);
    static Foodstuff tomato = new Foodstuff("Tomato", 25, 1, 3, 0,20, 40);

    static Recipe mashedPotatoes = new Recipe();
    static Recipe grilledMushrooms = new Recipe();
    static Recipe tomatoSoup = new Recipe();
    static Recipe grilledVegetables = new Recipe();
    static Recipe fruitSalad = new Recipe();

    public static void main(String[] args) {

        setUpRecipes();

        Recipe randomRecipe = getRandomRecipeForMeal("lunch");
        System.out.println(randomRecipe.name);

        ArrayList<Foodstuff> fruitSaladIngredients = new ArrayList<Foodstuff>();
        fruitSaladIngredients.add(apple);
        fruitSaladIngredients.add(orange);

        fruitSalad = new Recipe("Fruit Salad", "", 20, 4, Level.MEDIUM,
                fruitSaladIngredients);
        fruitSalad.setDescription("Edited description for fruit salad");
        System.out.println(fruitSalad.getDescription());

        String description = mashedPotatoes.getDescription();
        mashedPotatoes.setDescription("New desc for mashed potatoes");

        // Enum, ;
        String desc = Level.HARD.getDescription(Level.HARD);
        System.out.println(desc);

        // Null safety
        Foodstuff mashedPotatoesFirst = mashedPotatoes.getIngredients().stream().findFirst().get();
        if (mashedPotatoesFirst != null) {
            System.out.println(mashedPotatoesFirst.getCalories());
        }

        // Extension function - ne postoji
        String styledPrepationTime = mashedPotatoes.getStyledPreparationTime();
        System.out.println(styledPrepationTime);

        Recipe orangeSoda = new Recipe("Orange soda", "", 10, 1, Level.EASY, Stream.of(orange, soda).collect(Collectors.toList()));

        // String templates
        String fruitSaladDescription = "Food salad description is: " + fruitSalad.getDescription()
                + ", and it is for " + fruitSalad.getServes() + " persons.";

        String fruitSaladPrepTime = "Fruit salad prep time: " + fruitSalad.getPreparationTime();
        String fruitSaladServes = "Fruit salad serves: " + fruitSalad.getServes() * 2;

        System.out.println(fruitSaladServes);

        // lateinit
        String fruitSaladSimilarRecipes;
        // System.out.println(fruitSaladSimilarRecipes);

        // companion object
        Foodstuff healthier = Foodstuff.moreHealthier(spaghetti, asparagus);
        System.out.println("Healthier: " + healthier.getName());

        // Getter setter
        CookBook cookBook = new CookBook();
        cookBook.setTitle("Serbian cook book"); // access setter
        System.out.println(cookBook.getTitle()); // access getter

        // Elvis operator
        int recipeCount = cookBook.getRecipes() != null ? cookBook.getRecipes().size() : 0;
        System.out.println(recipeCount);

        // Collection function
        String mashedPotatoesString = mashedPotatoes.getIngredients().stream().map(Foodstuff::getName).collect(Collectors.joining(", "));
        System.out.println("Mashed potatoes ingredients: " + mashedPotatoesString);

        List<Foodstuff> mashedPotatoesFilter = mashedPotatoes.getIngredients().stream().filter(
                foodstuff -> !foodstuff.isGoodForDiabetics()
        ).collect(Collectors.toList());
        System.out.println("Bad for diabetics: " + mashedPotatoesFilter.stream().map(Foodstuff::getName).collect(Collectors.joining(", ")));

        List<Recipe> cookBookRecipes = Stream.of(grilledMushrooms, grilledVegetables, orangeSoda).collect(Collectors.toList());
        cookBook.setRecipes(cookBookRecipes);

        List<Recipe> sortedRecipesByPrepTime = cookBook.getRecipes().stream().sorted(
                Comparator.comparing(Recipe::getPreparationTime)
        ).collect(Collectors.toList());
        System.out.println(sortedRecipesByPrepTime);

        List<Recipe> sortedDescendingRecipesByPrepTime = sortedRecipesByPrepTime.stream().sorted(
                (recipe1, recipe2) -> recipe2.getPreparationTime().compareTo(recipe1.getPreparationTime())
        ).collect(Collectors.toList());
        System.out.println(sortedDescendingRecipesByPrepTime);

        List<Recipe> orangeRecipes = cookBook.getRecipes().stream().filter(
                recipe -> recipe.getName().contains("Orange")
        ).collect(Collectors.toList());
        System.out.println(orangeRecipes);

        Restaurant restaurant = new Restaurant("Serbian restaurant", "Address 1, Belgrade", Stream.of(grilledMushrooms, grilledVegetables, orangeSoda, mashedPotatoes, tomatoSoup, fruitSalad).collect(Collectors.toList()));
        System.out.println("Restaurant: " + restaurant.getName() + " has " + restaurant.diabetesAcceptableRecipes() + " recipes that are acceptable for diabetics.");

        Object variable = 10.0;
        if (variable instanceof Float) {
            System.out.println("variable is float");
        } else if (variable instanceof Integer) {
            System.out.println("variable is int");
        }
        Double newVariable = ((Double) variable) + 10;
        System.out.println(newVariable);
    }

    static void setUpRecipes() {
        ArrayList<Foodstuff> mashedPotatoesIngredients = new ArrayList<Foodstuff>();
        mashedPotatoesIngredients.add(potato);
        mashedPotatoesIngredients.add(milk);
        mashedPotatoesIngredients.add(water);
        mashedPotatoes = new Recipe("Mashed Potatoes", " Using a potato masher or electric beater, slowly blend milk mixture into potatoes until smooth and creamy.", 30, 3, Level.EASY, mashedPotatoesIngredients);

        ArrayList<Foodstuff> grilledMushroomsIngredients = new ArrayList<Foodstuff>();
        grilledMushroomsIngredients.add(mushrooms);
        grilledMushroomsIngredients.add(onion);
        grilledMushrooms = new Recipe("Grilled Mushrooms", "", 25, 2, Level.MEDIUM, grilledMushroomsIngredients);

        ArrayList<Foodstuff> tomatoSoupIngredients = new ArrayList<Foodstuff>();
        tomatoSoupIngredients.add(tomato);
        tomatoSoupIngredients.add(water);
        tomatoSoupIngredients.add(cucumber);
        tomatoSoup = new Recipe();

        ArrayList<Foodstuff> grilledVegetablesIngredients = new ArrayList<Foodstuff>();
        grilledVegetablesIngredients.add(asparagus);
        grilledVegetablesIngredients.add(broccoli);
        grilledVegetablesIngredients.add(carrot);
        grilledVegetablesIngredients.add(cauliflower);
        grilledVegetablesIngredients.add(mushrooms);
        grilledVegetablesIngredients.add(onion);
        grilledVegetables = new Recipe("Grilled Vegetables", "", 70, 4, Level.HARD, grilledVegetablesIngredients);

    }

    static Recipe getRandomRecipeForMeal(String meal) {
        switch (meal) {
            case "breakfast":
                return fruitSalad;
            case "snack":
                return tomatoSoup;
            case "lunch":
                return mashedPotatoes;
            default:
                return null;
        }
    }
}
