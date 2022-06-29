package models

class CookBook {

//    var title: String = ""

    var title: String = ""
        get() = field
        set(value) {
            field = value
        }
    var author: String = ""
    var pageCount: Int = 0
    var recipes: List<Recipe>? = listOf()
}