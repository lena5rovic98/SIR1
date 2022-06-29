package models

class Restaurant(var name: String, var address: String, var menu: List<Recipe>) {

    fun diabetesAcceptableRecipes(): Int {
        var count = 0
        for (recipe in menu) {
            if (recipe.isAcceptableForDiabetes) {
                count++
            }
        }
        return count
    }
}
