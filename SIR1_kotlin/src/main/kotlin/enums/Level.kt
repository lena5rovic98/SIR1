package enums

enum class Level {
    EASY,
    MEDIUM,
    HARD;

    fun getDescription(): String? {
        return when (this) {
            EASY -> "This recipe is very easy, you should try"
            MEDIUM -> "This is more complicated, pay attention!"
            HARD -> "Very hard, be careful"
        }
    }
}

