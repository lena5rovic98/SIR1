import models.Recipe;

import java.util.List;

public class Restaurant {
    private String name;
    private String address;
    private List<Recipe> menu;

    public Restaurant(String name, String address, List<Recipe> menu) {
        this.name = name;
        this.address = address;
        this.menu = menu;
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

    public List<Recipe> getMenu() {
        return menu;
    }

    public void setMenu(List<Recipe> menu) {
        this.menu = menu;
    }

    public int diabetesAcceptableRecipes() {
        int count = 0;
        for (Recipe recipe: menu) {
            if (recipe.isAcceptableForDiabetes()) {
                count++;
            }
        }
        return count;
    }
}
