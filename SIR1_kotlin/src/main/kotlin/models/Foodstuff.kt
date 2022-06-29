package models

data class Foodstuff(
    val name: String,
    var calories: Int, //Calories in kilocalories.
    var protein: Int, //Protein amount in grams.
    var sugar: Int, //Sugar or glucose amount in grams.
    var fats: Int, //Total fat amount in grams.
    var vitaminA: Int, //Vitamin A amount in percent.
    var vitaminC: Int, //Vitamin C amount in percent.
) {

    fun isGoodForDiabetics(): Boolean {
        return sugar < 3
    }

    companion object {
        fun convertKcalToCal(kcal: Int): Int {
            return kcal * 1000
        }

        fun moreHealthier(foodstuff1: Foodstuff, foodstuff2: Foodstuff): Foodstuff {
            return if (foodstuff1.calories < foodstuff2.calories && foodstuff1.protein > foodstuff2.protein) {
                foodstuff1
            } else foodstuff2
        }
    }
}

