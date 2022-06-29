package extensions

fun Int.getStyledPreparationTime(): String {
    val hours = this / 60
    val minutes = this % 60
    return "Preparation time: ${hours}h and ${minutes}min"
}

