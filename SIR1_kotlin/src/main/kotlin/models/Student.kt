class Student1 {
    var index: Int = 0
    var firstName: String = ""
    var lastName: String = ""

    constructor(firstName: String) {
        this.firstName = firstName
    }

    fun toUpper(): String {
        return firstName.toUpperCase()
    }
}

class Student2 constructor(index: Int, firstName: String, lastName: String) {}

class Student(var index: Int, var firstName: String, var lastName: String) {

    init {
        index = 1295
        firstName = "Lena"
        print("This is init block")
    }
}

//class Student(var index: Int, var firstName: String, var lastName: String) {}
//class Student(val index: Int, var firstName: String, var lastName: String) {}
//class Student(val index: Int, val firstName: String, val lastName: String? = "Petrovic") {}






